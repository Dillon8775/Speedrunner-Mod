package net.dillon8775.speedrunnermod.item;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.dillon8775.speedrunnermod.option.ModOptions;
import net.dillon8775.speedrunnermod.util.ChatGPT;
import net.dillon8775.speedrunnermod.util.ItemUtil;
import net.dillon8775.speedrunnermod.util.TickCalculator;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.info;
import static net.dillon8775.speedrunnermod.SpeedrunnerMod.options;

/**
 * An item that teleports the player to the nearest blaze spawner.
 */
public class BlazeSpotterItem extends Item {
    private boolean confirm = !options().client.confirmMessages;

    public BlazeSpotterItem(Settings settings) {
        super(settings.maxCount(options().main.stackUnstackables ? 64 : 16).group(ItemGroup.MISC));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        if (!world.isClient) {
            if (!options().advanced.disableBlazeSpotter) {
                if (world.getRegistryKey() == World.NETHER) {
                    BlockPos blazeSpawnerPos = this.findNearestBlazeSpawner((ServerWorld)world, player.getBlockPos());
                    if (blazeSpawnerPos != null) {
                        if (confirm) {
                            player.teleport(blazeSpawnerPos.getX() + 0.5F, blazeSpawnerPos.getY() + 1.0F, blazeSpawnerPos.getZ() + 0.5F, true);
                            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.HOSTILE, 1.0F, 1.0F);
                            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_BLAZE_AMBIENT, SoundCategory.HOSTILE, 3.0F, 0.6F);
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickCalculator.seconds(world.random.nextInt(4) + 7), 0, false, true, true));
                            player.getItemCooldownManager().set(this, TickCalculator.seconds(10));
                            if (!player.getAbilities().creativeMode) {
                                itemStack.decrement(1);
                            }
                            SpeedrunnerMod.debug("Teleported player" + player.getName().asString() + " (UUID: " + player.getUuidAsString() + ") to nearest blaze spawner, at X = " + player.getX() + ", Y = " + player.getY() + ", Z = " + player.getZ() + ".");
                        } else {
                            player.sendMessage(new TranslatableText("item.speedrunnermod.blaze_spotter.found_blaze_spawner").formatted(ItemUtil.toFormatting(Formatting.GOLD, Formatting.WHITE)), ModOptions.ItemMessages.isActionbar());
                            player.sendMessage(new TranslatableText("item.speedrunnermod.blaze_spotter.confirm"), false);
                        }
                        if (options().client.confirmMessages) {
                            confirm = !confirm;
                        }
                        player.swingHand(hand, true);
                        return TypedActionResult.success(player.getStackInHand(hand));
                    } else {
                        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 1.0F, 3.0F);
                        player.sendMessage(new TranslatableText("item.speedrunnermod.blaze_spotter.couldnt_find_spawner").formatted(ItemUtil.toFormatting(Formatting.GOLD, Formatting.WHITE)), ModOptions.ItemMessages.isActionbar());
                    }
                } else {
                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 1.0F, 5.0F);
                    player.sendMessage(new TranslatableText("item.speedrunnermod.blaze_spotter.wrong_dimension").formatted(ItemUtil.toFormatting(Formatting.GOLD, Formatting.WHITE)), ModOptions.ItemMessages.isActionbar());
                }
            } else {
                player.sendMessage(new TranslatableText("item.speedrunnermod.item_disabled").formatted(ItemUtil.toFormatting(Formatting.GOLD, Formatting.WHITE)), ModOptions.ItemMessages.isActionbar());
                info("Player " + player.getName().asString() + " (" + player.getUuidAsString() + ") tried to use Blaze Spotter, but is disabled!");
            }
        }

        return TypedActionResult.consume(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (options().client.itemTooltips) {
            tooltip.add(new TranslatableText("item.speedrunnermod.blaze_spotter.tooltip"));
        }
    }

    /**
     * Finds the nearest blaze spawner.
     */
    @ChatGPT
    private BlockPos findNearestBlazeSpawner(ServerWorld world, BlockPos fortressPos) {
        for (BlockPos pos : BlockPos.iterate(fortressPos.add(options().advanced.blazeSpotterDistanceXYZ[0], options().advanced.blazeSpotterDistanceXYZ[1], options().advanced.blazeSpotterDistanceXYZ[2]), fortressPos.add(options().advanced.blazeSpotterDistanceXYZ[3], options().advanced.blazeSpotterDistanceXYZ[4], options().advanced.blazeSpotterDistanceXYZ[5]))) {
            if (world.getBlockState(pos).getBlock() == Blocks.SPAWNER) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof MobSpawnerBlockEntity) {
                    MobSpawnerBlockEntity spawnerBlockEntity = (MobSpawnerBlockEntity) blockEntity;
                    if (spawnerBlockEntity.getLogic().getRenderedEntity(world).getType() == EntityType.BLAZE) {
                        if (!world.getBlockState(pos.up()).isAir() || !world.getBlockState(pos.up(1)).isAir()) {
                            SpeedrunnerMod.debug("Detected blocks above blaze spawner were not air, so setting to air.");
                            for (int i = 1; i < 3; i++) {
                                world.setBlockState(pos.up(i), Blocks.AIR.getDefaultState(), 3);
                            }
                        }
                        return pos.toImmutable();
                    }
                }
            }
        }

        return null;
    }
}