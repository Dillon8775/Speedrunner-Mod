package net.dillon8775.speedrunnermod.item;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.dillon8775.speedrunnermod.option.ModOptions;
import net.dillon8775.speedrunnermod.util.ItemUtil;
import net.dillon8775.speedrunnermod.util.TickCalculator;
import net.dillon8775.speedrunnermod.util.TimeCalculator;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.info;
import static net.dillon8775.speedrunnermod.SpeedrunnerMod.options;

/**
 * An item that kills all {@link net.minecraft.entity.raid.RaiderEntity}s.
 */
public class RaidEradicatorItem extends Item {
    private boolean confirm = !options().client.confirmMessages;

    public RaidEradicatorItem(Settings settings) {
        super(settings.rarity(Rarity.EPIC).maxCount(1).group(ItemGroup.MISC));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        if (!world.isClient) {
            if (!options().advanced.disableRaidEradicator) {
                List<RaiderEntity> raiders = world.getEntitiesByClass(RaiderEntity.class, player.getBoundingBox().expand(options().advanced.raidEradicatorDistanceXYZ[0], options().advanced.raidEradicatorDistanceXYZ[1], options().advanced.raidEradicatorDistanceXYZ[2]), entity -> true);

                if (!raiders.isEmpty()) {
                    boolean hasTotemEquipped = player.getMainHandStack().isOf(Items.TOTEM_OF_UNDYING) || player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING);
                    if (player.getAbilities().creativeMode) {
                        hasTotemEquipped = true;
                    }

                    if (hasTotemEquipped) {
                        if (confirm) {
                            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_RAVAGER_ROAR, SoundCategory.HOSTILE, 3.0F, 1.0F);
                            player.getItemCooldownManager().set(this, TickCalculator.seconds(30));
                            if (!player.getAbilities().creativeMode) {
                                stack.decrement(1);
                            }
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    for (RaiderEntity raider : raiders) {
                                        if (!raider.hasCustomName()) {
                                            if (!(raider instanceof WitchEntity)) {
                                                raider.kill();
                                            } else {
                                                raider.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, TickCalculator.seconds(30), 2, false, true, false));
                                                raider.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, TickCalculator.seconds(30), 1, false, true, false));
                                                raider.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, TickCalculator.minutes(2), 0, false, true, false));
                                                raider.teleport(player.getX() + world.random.nextInt(7) - 3, player.getY() + world.random.nextDouble() * (2.0 - 0.5) + 0.5, player.getZ() + world.random.nextInt(7) - 3);
                                            }
                                            SpeedrunnerMod.debug("Killed raider entity, " + raider.getName().asString() + " (" + raider.getUuidAsString() + ").");
                                        }
                                    }
                                    player.damage(DamageSource.GENERIC, player.getHealth());
                                    player.sendMessage(new TranslatableText("item.speedrunnermod.raid_eradicator.success").formatted(Formatting.RED), false);
                                }
                            }, TimeCalculator.secondsToMilliseconds(3));
                        } else {
                            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_VINDICATOR_AMBIENT, SoundCategory.HOSTILE, 3.0F, 1.0F);
                            player.sendMessage(new TranslatableText("item.speedrunnermod.raid_eradicator.found_raiders").formatted(ItemUtil.toFormatting(Formatting.YELLOW, Formatting.WHITE)), ModOptions.ItemMessages.isActionbar());
                            player.sendMessage(new TranslatableText("item.speedrunnermod.raid_eradicator.confirm"), false);
                        }
                        if (options().client.confirmMessages) {
                            confirm = !confirm;
                        }
                        player.swingHand(hand, true);
                        return TypedActionResult.success(stack);
                    } else {
                        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_WITCH_AMBIENT, SoundCategory.NEUTRAL, 3.0F, 1.0F);
                        player.sendMessage(new TranslatableText("item.speedrunnermod.raid_eradicator.no_totem").formatted(Formatting.YELLOW), ModOptions.ItemMessages.isActionbar());
                    }
                } else {
                    player.sendMessage(new TranslatableText("item.speedrunnermod.raid_eradicator.couldnt_find_raiders"), ModOptions.ItemMessages.isActionbar());
                }
            } else {
                player.sendMessage(new TranslatableText("item.speedrunnermod.item_disabled"), false);
                info("Player " + player.getName().asString() + " (" + player.getUuidAsString() + ") tried to use Raid Eradicator, but is disabled!");
            }
        }

        return TypedActionResult.consume(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (options().client.itemTooltips) {
            tooltip.add(new TranslatableText("item.speedrunnermod.raid_eradicator.tooltip"));
        }
    }
}