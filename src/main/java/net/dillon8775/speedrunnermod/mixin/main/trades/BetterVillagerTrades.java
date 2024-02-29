package net.dillon8775.speedrunnermod.mixin.main.trades;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.dillon8775.speedrunnermod.item.ModItems;
import net.dillon8775.speedrunnermod.village.ModTradeOffers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.map.MapIcon;
import net.minecraft.util.Util;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

/**
 * <p>Makes default Minecraft villager trades, better!</p>
 * <p>Turns out, Minecraft's code is broken, so I had to fix it.</p>
 * <p>---</p>
 * {@link net.minecraft.village.TradeOffers.TypeAwareBuyForOneEmeraldFactory} wasn't working correctly, so I had to cast the {@link ImmutableMap#builder()} to a default {@link Map} in order for it to work.
 */
@Deprecated
@Mixin(TradeOffers.class)
public class BetterVillagerTrades {
    @Shadow
    public static final Map<VillagerProfession, Int2ObjectMap<TradeOffers.Factory[]>> PROFESSION_TO_LEVELED_TRADE = SpeedrunnerMod.options().betterVillagerTrades ? Util.make(Maps.newHashMap(), map -> {
        map.put(VillagerProfession.FARMER, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.WHEAT, 2, 24, 2),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.POTATO, 3, 24, 2),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.CARROT, 3, 24, 2),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.BEETROOT, 2, 24, 2),
                                new ModTradeOffers.SellItemFactorySpeedrunnerIngot(Items.EMERALD, 3, 16, 3),
                                new TradeOffers.SellItemFactory(Items.BREAD, 1, 6, 24, 3)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.PUMPKIN, 2, 16, 10),
                                new TradeOffers.SellItemFactory(Items.PUMPKIN_PIE, 1, 6, 6),
                                new ModTradeOffers.SellItemFactorySpeedrunnerIngot(Items.APPLE, 1, 4, 24, 7)},
                        3, new TradeOffers.Factory[]{
                                new ModTradeOffers.SellItemFactorySpeedrunnerIngot(Items.COOKIE, 1, 24, 11),
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.MELON, 2, 16, 20)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(Blocks.CAKE, 1, 1, 16, 15),
                                new TradeOffers.SellSuspiciousStewFactory(StatusEffects.NIGHT_VISION, 210, 15),
                                new TradeOffers.SellSuspiciousStewFactory(StatusEffects.JUMP_BOOST, 230, 15),
                                new TradeOffers.SellSuspiciousStewFactory(StatusEffects.SPEED, 220, 15),
                                new TradeOffers.SellSuspiciousStewFactory(StatusEffects.STRENGTH, 200, 15),
                                new TradeOffers.SellSuspiciousStewFactory(StatusEffects.HASTE, 320, 15),
                                new TradeOffers.SellSuspiciousStewFactory(StatusEffects.SATURATION, 9, 15)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(Items.GOLDEN_CARROT, 1, 4, 30),
                                new TradeOffers.SellItemFactory(Items.GLISTERING_MELON_SLICE, 1, 4, 30)})));

        map.put(VillagerProfession.FISHERMAN, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.STRING, 2, 32, 2),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 1, 32, 2),
                                new TradeOffers.ProcessItemFactory(Items.BEEF, 4, Items.COOKED_BEEF, 6, 32, 2),
                                new TradeOffers.SellItemFactory(Items.COD_BUCKET, 1, 1, 18, 1)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.BEEF, 2, 32, 10),
                                new TradeOffers.ProcessItemFactory(Items.APPLE, 4, Items.GOLDEN_APPLE, 6, 16, 5),
                                new TradeOffers.SellItemFactory(Items.CAMPFIRE, 1, 1, 5),
                                new TradeOffers.SellItemFactory(ModItems.SPEEDRUNNER_BULK, 9, 1, 8, 10)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.PORKCHOP, 2, 32, 20),
                                new ModTradeOffers.SellMaxedEnchantedToolFactory(Items.FISHING_ROD, 4, 4, 16)},
                        4, new TradeOffers.Factory[]{
                                new ModTradeOffers.SellItemFactorySpeedrunnerIngot(Items.EMERALD, 3, 24, 30)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.PUFFERFISH, 2, 16, 30),
                                new TradeOffers.TypeAwareBuyForOneEmeraldFactory(1, 12, 30,
                                        (Map) ImmutableMap.builder()
                                                .put(VillagerType.PLAINS, Items.OAK_BOAT)
                                                .put(VillagerType.TAIGA, Items.SPRUCE_BOAT)
                                                .put(VillagerType.SNOW, Items.SPRUCE_BOAT)
                                                .put(VillagerType.DESERT, Items.JUNGLE_BOAT)
                                                .put(VillagerType.JUNGLE, Items.JUNGLE_BOAT)
                                                .put(VillagerType.SAVANNA, Items.ACACIA_BOAT)
                                                .put(VillagerType.SWAMP, Items.DARK_OAK_BOAT).build())})));

        map.put(VillagerProfession.SHEPHERD, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.WHITE_WOOL, 4, 24, 2),
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.BROWN_WOOL, 4, 24, 2),
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.BLACK_WOOL, 4, 24, 2),
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.GRAY_WOOL, 4, 24, 2),
                                new ModTradeOffers.SellItemFactoryIronIngot(Items.SHEARS, 1, 1, 1),
                                new ModTradeOffers.SellItemFactorySpeedrunnerIngot(ModItems.SPEEDRUNNER_SHEARS, 1, 1, 2)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.WHITE_DYE, 2, 24, 10),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.GRAY_DYE, 2, 24, 10),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.BLACK_DYE, 2, 24, 10),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.LIGHT_BLUE_DYE, 2, 24, 10),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.LIME_DYE, 2, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.WHITE_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.ORANGE_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.MAGENTA_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.YELLOW_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.LIME_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.PINK_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.GRAY_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.CYAN_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.PURPLE_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.BLUE_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.BROWN_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.GREEN_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.RED_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.BLACK_WOOL, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.WHITE_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.ORANGE_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.MAGENTA_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.YELLOW_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.LIME_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.PINK_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.GRAY_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.CYAN_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.PURPLE_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.BLUE_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.BROWN_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.GREEN_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.RED_CARPET, 1, 4, 24, 5),
                                new TradeOffers.SellItemFactory(Blocks.BLACK_CARPET, 1, 4, 24, 5)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.YELLOW_DYE, 1, 24, 20),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.LIGHT_GRAY_DYE, 1, 24, 20),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.ORANGE_DYE, 1, 24, 20),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.RED_DYE, 1, 24, 20),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.PINK_DYE, 1, 24, 20),
                                new TradeOffers.SellItemFactory(Blocks.WHITE_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.YELLOW_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.RED_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.BLACK_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.BLUE_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.BROWN_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.CYAN_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.GRAY_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.GREEN_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.LIME_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.MAGENTA_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.ORANGE_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.PINK_BED, 1, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.PURPLE_BED, 1, 1, 24, 10)},

                        4,new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.BROWN_DYE, 1, 32, 30),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.PURPLE_DYE, 1, 32, 30),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.BLUE_DYE, 1, 32, 30),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.GREEN_DYE, 1, 32, 30),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.MAGENTA_DYE, 1, 32, 30),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.CYAN_DYE, 1, 32, 30),
                                new TradeOffers.SellItemFactory(Items.WHITE_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.BLUE_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.LIGHT_BLUE_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.RED_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.PINK_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.GREEN_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.LIME_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.GRAY_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.BLACK_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.PURPLE_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.MAGENTA_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.CYAN_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.BROWN_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.YELLOW_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.ORANGE_BANNER, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Items.LIGHT_GRAY_BANNER, 1, 1, 24, 15)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(Items.PAINTING, 2, 4, 32, 30)})));

        map.put(VillagerProfession.FLETCHER, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.STICK, 4, 32, 3),
                                new TradeOffers.SellItemFactory(Items.ARROW, 1, 32, 2),
                                new TradeOffers.ProcessItemFactory(Blocks.GRAVEL, 1, Items.FLINT, 1, 24, 1)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Items.BOW, 1, 1, 5),
                                new ModTradeOffers.SellItemFactorySpeedrunnerIngot(ModItems.SPEEDRUNNER_BOW, 3, 1, 6)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.STRING, 14, 16, 20),
                                new TradeOffers.SellItemFactory(Items.CROSSBOW, 1, 1, 10),
                                new ModTradeOffers.SellItemFactorySpeedrunnerIngot(ModItems.SPEEDRUNNER_CROSSBOW, 3, 1, 11)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.FEATHER, 24, 16, 30),
                                new TradeOffers.SellEnchantedToolFactory(Items.BOW, 1, 6, 15),
                                new TradeOffers.SellEnchantedToolFactory(ModItems.SPEEDRUNNER_BOW, 1, 6, 20)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.TRIPWIRE_HOOK, 2, 24, 30),
                                new TradeOffers.SellEnchantedToolFactory(Items.CROSSBOW, 1, 6, 15),
                                new TradeOffers.SellEnchantedToolFactory(ModItems.SPEEDRUNNER_CROSSBOW, 1, 6, 25),
                                new TradeOffers.SellPotionHoldingItemFactory(Items.ARROW, 1, Items.TIPPED_ARROW, 4, 1, 32, 40)})));

        map.put(VillagerProfession.LIBRARIAN, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.PAPER, 3, 32, 2),
                                new ModTradeOffers.MaxedEnchantBookFactory(2, 16, 4, 0.01F),
                                new TradeOffers.SellItemFactory(Blocks.BOOKSHELF, 3, 1, 24, 2)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.BOOK, 4, 32, 10),
                                new ModTradeOffers.MaxedEnchantBookFactory(1, 16, 15, 0.01F),
                                new TradeOffers.SellItemFactory(Items.LANTERN, 1, 4, 24, 5)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.INK_SAC, 6, 24, 20),
                                new ModTradeOffers.MaxedEnchantBookFactory(1, 24, 25, 0.01F),
                                new TradeOffers.SellItemFactory(Items.GLASS, 1, 4, 64,10)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.WRITABLE_BOOK, 1, 32, 30),
                                new ModTradeOffers.MaxedEnchantBookFactory(1, 32, 35, 0.01F),
                                new TradeOffers.SellItemFactory(Items.CLOCK, 5, 1, 15),
                                new TradeOffers.SellItemFactory(Items.COMPASS, 4, 1, 15)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(Items.NAME_TAG, 1, 2, 40)})));

        map.put(VillagerProfession.CARTOGRAPHER, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.PAPER, 2, 24, 2),
                                new TradeOffers.SellItemFactory(Items.MAP, 1, 1, 1)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.GLASS_PANE, 1, 32, 10),
                                new TradeOffers.SellMapFactory(2, StructureFeature.MONUMENT, MapIcon.Type.MONUMENT, 12, 5)},
                        3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COMPASS, 1, 12, 20),
                                new TradeOffers.SellMapFactory(3, StructureFeature.MANSION, MapIcon.Type.MANSION, 12, 10),
                                new TradeOffers.SellItemFactory(ModItems.SPEEDRUNNERS_EYE, 2, 1, 20)},
                        4, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.ITEM_FRAME, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.WHITE_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.BLUE_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.LIGHT_BLUE_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.RED_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.PINK_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.GREEN_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.LIME_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.GRAY_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.BLACK_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.PURPLE_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.MAGENTA_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.CYAN_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.BROWN_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.YELLOW_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.ORANGE_BANNER, 1, 1, 15),
                                new TradeOffers.SellItemFactory(Items.LIGHT_GRAY_BANNER, 1, 1, 15)},
                        5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.GLOBE_BANNER_PATTERN, 2, 1, 30)})));

        map.put(VillagerProfession.CLERIC, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.ROTTEN_FLESH, 3, 32, 2),
                                new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 4, 32, 21)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 2, 32, 10),
                                new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 2, 8)},
                        3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.RABBIT_FOOT, 2, 12, 20),
                                new TradeOffers.SellItemFactory(Blocks.GLOWSTONE, 1, 4, 32, 10)},
                        4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SCUTE, 1, 16, 30),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.GLASS_BOTTLE, 3, 32, 30),
                                new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 1, 1, 8, 15)},
                        5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.NETHER_WART, 4, 32, 30),
                                new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 2, 1, 32, 30)})));

        map.put(VillagerProfession.ARMORER, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 2, 32, 2),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_LEGGINGS), 2, 1, 16, 1, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_BOOTS), 1, 1, 16, 1, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_HELMET), 1, 1, 16, 1, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_CHESTPLATE), 2, 1, 16, 1, 0.01F)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 1, 32, 10),
                                new TradeOffers.BuyForOneEmeraldFactory(ModItems.SPEEDRUNNER_INGOT, 1, 32, 12),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.BELL), 4, 1, 24, 5, 0.1F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_BOOTS), 1, 1, 24, 5, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_LEGGINGS), 2, 1, 24, 5, 0.01F)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.LAVA_BUCKET, 1, 32, 20),
                                new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND, 1, 24, 20),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_HELMET), 1, 1, 24, 10, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 2, 1, 24, 10, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.SHIELD), 1, 1, 24, 10, 0.1F),
                                new TradeOffers.SellItemFactory(new ItemStack(ModItems.SPEEDRUNNER_SHIELD), 1, 1, 32, 12, 0.15F)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 4, 16, 15, 0.01F),
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 3, 16, 15, 0.01F)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HELMET, 3, 16, 50, 0.01F),
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 5, 16, 50, 0.1F)})));

        map.put(VillagerProfession.WEAPONSMITH, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 2, 32, 2),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_AXE), 1, 1, 24, 2, 0.01F),
                                new TradeOffers.SellEnchantedToolFactory(Items.IRON_SWORD, 2, 24, 2)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 1, 32, 10),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.BELL), 4, 1, 24, 5, 0.01F)},
                        3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 1, 32, 20)},
                        4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND, 1, 24, 30),
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 4, 16, 30, 0.01F)},
                        5, new TradeOffers.Factory[]{new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SWORD, 3, 16, 30, 0.01F)})));

        map.put(VillagerProfession.TOOLSMITH, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 2, 32, 2),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_AXE), 1, 1, 24, 1, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_SHOVEL), 1, 1, 24, 1, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_PICKAXE), 1, 1, 24, 1, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_HOE), 1, 1, 24, 1, 0.01F)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 1, 32, 10),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.BELL), 4, 1, 24, 5, 0.01F)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 1, 32, 20),
                                new TradeOffers.SellEnchantedToolFactory(Items.IRON_AXE, 2, 24, 10, 0.01F),
                                new TradeOffers.SellEnchantedToolFactory(Items.IRON_SHOVEL, 1, 24, 10, 0.01F),
                                new TradeOffers.SellEnchantedToolFactory(Items.IRON_PICKAXE, 1, 24, 10, 0.01F),
                                new TradeOffers.SellItemFactory(new ItemStack(Items.DIAMOND_HOE), 1, 1, 24, 10, 0.1F)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND, 1, 24, 30),
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 2, 24, 15, 0.01F),
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SHOVEL, 1, 24, 15, 0.01F)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_PICKAXE, 2, 24, 50, 0.01F)})));

        map.put(VillagerProfession.BUTCHER, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(Items.COOKED_CHICKEN, 1, 8, 32,2),
                                new TradeOffers.SellItemFactory(Items.COOKED_PORKCHOP, 1, 8, 32, 2),
                                new TradeOffers.SellItemFactory(Items.COOKED_RABBIT, 1, 6, 32, 2),
                                new TradeOffers.SellItemFactory(Items.RABBIT_STEW, 1, 1, 24, 1)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 2, 32, 2),
                                new TradeOffers.SellItemFactory(Items.COOKED_BEEF, 1, 8, 32, 5),
                                new TradeOffers.SellItemFactory(ModItems.GOLDEN_BEEF, 2, 8, 24, 5)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(ModItems.GOLDEN_MUTTON, 2, 8, 32, 20),
                                new TradeOffers.SellItemFactory(ModItems.GOLDEN_PORKCHOP, 3, 8, 32, 20)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.DRIED_KELP_BLOCK, 1, 24, 30)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.SWEET_BERRIES, 1, 32, 30)})));

        map.put(VillagerProfession.LEATHERWORKER, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.LEATHER, 2, 32, 2),
                                new TradeOffers.SellDyedArmorFactory(Items.LEATHER_LEGGINGS, 1),
                                new TradeOffers.SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 1)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 1, 32, 10),
                                new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HELMET, 1, 24, 5),
                                new TradeOffers.SellDyedArmorFactory(Items.LEATHER_BOOTS, 1, 24, 5)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.RABBIT_HIDE, 1, 32, 20),
                                new TradeOffers.SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 1)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.SCUTE, 1, 24, 30),
                                new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HORSE_ARMOR, 1, 24, 15)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(new ItemStack(Items.SADDLE), 1, 1, 32, 30, 0.01F),
                                new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HELMET, 1, 24, 30)})));

        map.put(VillagerProfession.MASON, TradeOffers.copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.CLAY_BALL, 2, 32, 2),
                                new TradeOffers.SellItemFactory(Items.BRICK, 1, 16, 32, 1)},
                        2, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.STONE, 1, 24, 10),
                                new TradeOffers.SellItemFactory(Blocks.CHISELED_STONE_BRICKS, 1, 4, 64, 5)},
                        3, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.GRANITE, 4, 32, 20),
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.ANDESITE, 4, 32, 20),
                                new TradeOffers.BuyForOneEmeraldFactory(Blocks.DIORITE, 4, 32, 20),
                                new TradeOffers.SellItemFactory(Blocks.DRIPSTONE_BLOCK, 1, 4, 32, 10),
                                new TradeOffers.SellItemFactory(Blocks.POLISHED_ANDESITE, 1, 4, 32, 10),
                                new TradeOffers.SellItemFactory(Blocks.POLISHED_DIORITE, 1, 4, 32, 10),
                                new TradeOffers.SellItemFactory(Blocks.POLISHED_GRANITE, 1, 4, 32, 10)},
                        4, new TradeOffers.Factory[]{
                                new TradeOffers.BuyForOneEmeraldFactory(Items.QUARTZ, 3, 32, 30),
                                new TradeOffers.SellItemFactory(Blocks.ORANGE_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.WHITE_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.BLUE_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.GRAY_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.BLACK_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.RED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.PINK_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.MAGENTA_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.LIME_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.GREEN_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.CYAN_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.PURPLE_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.YELLOW_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.BROWN_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.ORANGE_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.WHITE_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.BLUE_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.GRAY_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.BLACK_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.RED_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.PINK_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.MAGENTA_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.LIME_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.GREEN_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.CYAN_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.PURPLE_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.YELLOW_GLAZED_TERRACOTTA, 1, 1, 24, 15),
                                new TradeOffers.SellItemFactory(Blocks.BROWN_GLAZED_TERRACOTTA, 1, 1, 24, 15)},
                        5, new TradeOffers.Factory[]{
                                new TradeOffers.SellItemFactory(Blocks.QUARTZ_PILLAR, 1, 4, 32, 30),
                                new TradeOffers.SellItemFactory(Blocks.QUARTZ_BLOCK, 1, 4, 32, 30)})));

    }) : /* If Better trades AREN't enabled, switch to default code, or default trades. */
            Util.make(Maps.newHashMap(), map -> {
        map.put(VillagerProfession.FARMER, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.WHEAT, 20, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Items.POTATO, 26, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Items.CARROT, 22, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Items.BEETROOT, 15, 16, 2), new TradeOffers.SellItemFactory(Items.BREAD, 1, 6, 16, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Blocks.PUMPKIN, 6, 12, 10), new TradeOffers.SellItemFactory(Items.PUMPKIN_PIE, 1, 4, 5), new TradeOffers.SellItemFactory(Items.APPLE, 1, 4, 16, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.COOKIE, 3, 18, 10), new TradeOffers.BuyForOneEmeraldFactory(Blocks.MELON, 4, 12, 20)}, 4, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Blocks.CAKE, 1, 1, 12, 15), new TradeOffers.SellSuspiciousStewFactory(StatusEffects.NIGHT_VISION, 100, 15), new TradeOffers.SellSuspiciousStewFactory(StatusEffects.JUMP_BOOST, 160, 15), new TradeOffers.SellSuspiciousStewFactory(StatusEffects.WEAKNESS, 140, 15), new TradeOffers.SellSuspiciousStewFactory(StatusEffects.BLINDNESS, 120, 15), new TradeOffers.SellSuspiciousStewFactory(StatusEffects.POISON, 280, 15), new TradeOffers.SellSuspiciousStewFactory(StatusEffects.SATURATION, 7, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.GOLDEN_CARROT, 3, 3, 30), new TradeOffers.SellItemFactory(Items.GLISTERING_MELON_SLICE, 4, 3, 30)})));
        map.put(VillagerProfession.FISHERMAN, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.STRING, 20, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 10, 16, 2), new TradeOffers.ProcessItemFactory(Items.COD, 6, Items.COOKED_COD, 6, 16, 1), new TradeOffers.SellItemFactory(Items.COD_BUCKET, 3, 1, 16, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COD, 15, 16, 10), new TradeOffers.ProcessItemFactory(Items.SALMON, 6, Items.COOKED_SALMON, 6, 16, 5), new TradeOffers.SellItemFactory(Items.CAMPFIRE, 2, 1, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SALMON, 13, 16, 20), new TradeOffers.SellEnchantedToolFactory(Items.FISHING_ROD, 3, 3, 10, 0.2f)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.TROPICAL_FISH, 6, 12, 30)}, 5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PUFFERFISH, 4, 12, 30), new TradeOffers.TypeAwareBuyForOneEmeraldFactory(1, 12, 30, (Map)ImmutableMap.builder().put(VillagerType.PLAINS, Items.OAK_BOAT).put(VillagerType.TAIGA, Items.SPRUCE_BOAT).put(VillagerType.SNOW, Items.SPRUCE_BOAT).put(VillagerType.DESERT, Items.JUNGLE_BOAT).put(VillagerType.JUNGLE, Items.JUNGLE_BOAT).put(VillagerType.SAVANNA, Items.ACACIA_BOAT).put(VillagerType.SWAMP, Items.DARK_OAK_BOAT).build())})));
        map.put(VillagerProfession.SHEPHERD, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Blocks.WHITE_WOOL, 18, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Blocks.BROWN_WOOL, 18, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Blocks.BLACK_WOOL, 18, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Blocks.GRAY_WOOL, 18, 16, 2), new TradeOffers.SellItemFactory(Items.SHEARS, 2, 1, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.WHITE_DYE, 12, 16, 10), new TradeOffers.BuyForOneEmeraldFactory(Items.GRAY_DYE, 12, 16, 10), new TradeOffers.BuyForOneEmeraldFactory(Items.BLACK_DYE, 12, 16, 10), new TradeOffers.BuyForOneEmeraldFactory(Items.LIGHT_BLUE_DYE, 12, 16, 10), new TradeOffers.BuyForOneEmeraldFactory(Items.LIME_DYE, 12, 16, 10), new TradeOffers.SellItemFactory(Blocks.WHITE_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.ORANGE_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.MAGENTA_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.YELLOW_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.LIME_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.PINK_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.GRAY_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.CYAN_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.PURPLE_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.BLUE_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.BROWN_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.GREEN_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.RED_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.BLACK_WOOL, 1, 1, 16, 5), new TradeOffers.SellItemFactory(Blocks.WHITE_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.ORANGE_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.MAGENTA_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.YELLOW_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.LIME_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.PINK_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.GRAY_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.CYAN_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.PURPLE_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.BLUE_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.BROWN_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.GREEN_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.RED_CARPET, 1, 4, 16, 5), new TradeOffers.SellItemFactory(Blocks.BLACK_CARPET, 1, 4, 16, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.YELLOW_DYE, 12, 16, 20), new TradeOffers.BuyForOneEmeraldFactory(Items.LIGHT_GRAY_DYE, 12, 16, 20), new TradeOffers.BuyForOneEmeraldFactory(Items.ORANGE_DYE, 12, 16, 20), new TradeOffers.BuyForOneEmeraldFactory(Items.RED_DYE, 12, 16, 20), new TradeOffers.BuyForOneEmeraldFactory(Items.PINK_DYE, 12, 16, 20), new TradeOffers.SellItemFactory(Blocks.WHITE_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.YELLOW_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.RED_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.BLACK_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.BLUE_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.BROWN_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.CYAN_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.GRAY_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.GREEN_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.LIME_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.MAGENTA_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.ORANGE_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.PINK_BED, 3, 1, 12, 10), new TradeOffers.SellItemFactory(Blocks.PURPLE_BED, 3, 1, 12, 10)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BROWN_DYE, 12, 16, 30), new TradeOffers.BuyForOneEmeraldFactory(Items.PURPLE_DYE, 12, 16, 30), new TradeOffers.BuyForOneEmeraldFactory(Items.BLUE_DYE, 12, 16, 30), new TradeOffers.BuyForOneEmeraldFactory(Items.GREEN_DYE, 12, 16, 30), new TradeOffers.BuyForOneEmeraldFactory(Items.MAGENTA_DYE, 12, 16, 30), new TradeOffers.BuyForOneEmeraldFactory(Items.CYAN_DYE, 12, 16, 30), new TradeOffers.SellItemFactory(Items.WHITE_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.BLUE_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.RED_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.PINK_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.GREEN_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.LIME_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.GRAY_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.BLACK_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.PURPLE_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.CYAN_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.BROWN_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.YELLOW_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.ORANGE_BANNER, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 12, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.PAINTING, 2, 3, 30)})));
        map.put(VillagerProfession.FLETCHER, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.STICK, 32, 16, 2), new TradeOffers.SellItemFactory(Items.ARROW, 1, 16, 1), new TradeOffers.ProcessItemFactory(Blocks.GRAVEL, 10, Items.FLINT, 10, 12, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 26, 12, 10), new TradeOffers.SellItemFactory(Items.BOW, 2, 1, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.STRING, 14, 16, 20), new TradeOffers.SellItemFactory(Items.CROSSBOW, 3, 1, 10)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FEATHER, 24, 16, 30), new TradeOffers.SellEnchantedToolFactory(Items.BOW, 2, 3, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.TRIPWIRE_HOOK, 8, 12, 30), new TradeOffers.SellEnchantedToolFactory(Items.CROSSBOW, 3, 3, 15), new TradeOffers.SellPotionHoldingItemFactory(Items.ARROW, 5, Items.TIPPED_ARROW, 5, 2, 12, 30)})));
        map.put(VillagerProfession.LIBRARIAN, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PAPER, 24, 16, 2), new TradeOffers.EnchantBookFactory(1), new TradeOffers.SellItemFactory(Blocks.BOOKSHELF, 9, 1, 12, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BOOK, 4, 12, 10), new TradeOffers.EnchantBookFactory(5), new TradeOffers.SellItemFactory(Items.LANTERN, 1, 1, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.INK_SAC, 5, 12, 20), new TradeOffers.EnchantBookFactory(10), new TradeOffers.SellItemFactory(Items.GLASS, 1, 4, 10)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.WRITABLE_BOOK, 2, 12, 30), new TradeOffers.EnchantBookFactory(15), new TradeOffers.SellItemFactory(Items.CLOCK, 5, 1, 15), new TradeOffers.SellItemFactory(Items.COMPASS, 4, 1, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.NAME_TAG, 20, 1, 30)})));
        map.put(VillagerProfession.CARTOGRAPHER, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PAPER, 24, 16, 2), new TradeOffers.SellItemFactory(Items.MAP, 7, 1, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GLASS_PANE, 11, 16, 10), new TradeOffers.SellMapFactory(13, StructureFeature.MONUMENT, MapIcon.Type.MONUMENT, 12, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COMPASS, 1, 12, 20), new TradeOffers.SellMapFactory(14, StructureFeature.MANSION, MapIcon.Type.MANSION, 12, 10)}, 4, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.ITEM_FRAME, 7, 1, 15), new TradeOffers.SellItemFactory(Items.WHITE_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.BLUE_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.RED_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.PINK_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.GREEN_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.LIME_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.GRAY_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.BLACK_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.PURPLE_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.CYAN_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.BROWN_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.YELLOW_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.ORANGE_BANNER, 3, 1, 15), new TradeOffers.SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.GLOBE_BANNER_PATTERN, 8, 1, 30)})));
        map.put(VillagerProfession.CLERIC, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.ROTTEN_FLESH, 32, 16, 2), new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 2, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 3, 12, 10), new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 1, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.RABBIT_FOOT, 2, 12, 20), new TradeOffers.SellItemFactory(Blocks.GLOWSTONE, 4, 1, 12, 10)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30), new TradeOffers.BuyForOneEmeraldFactory(Items.GLASS_BOTTLE, 9, 12, 30), new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 5, 1, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.NETHER_WART, 22, 12, 30), new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 30)})));
        map.put(VillagerProfession.ARMORER, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_LEGGINGS), 7, 1, 12, 1, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_BOOTS), 4, 1, 12, 1, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_HELMET), 5, 1, 12, 1, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_CHESTPLATE), 9, 1, 12, 1, 0.2f)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 4, 12, 10), new TradeOffers.SellItemFactory(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_BOOTS), 1, 1, 12, 5, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_LEGGINGS), 3, 1, 12, 5, 0.2f)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.LAVA_BUCKET, 1, 12, 20), new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND, 1, 12, 20), new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_HELMET), 1, 1, 12, 10, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 4, 1, 12, 10, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.SHIELD), 5, 1, 12, 10, 0.2f)}, 4, new TradeOffers.Factory[]{new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 14, 3, 15, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 8, 3, 15, 0.2f)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HELMET, 8, 3, 30, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 16, 3, 30, 0.2f)})));
        map.put(VillagerProfession.WEAPONSMITH, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new TradeOffers.SellItemFactory(new ItemStack(Items.IRON_AXE), 3, 1, 12, 1, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.IRON_SWORD, 2, 3, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 4, 12, 10), new TradeOffers.SellItemFactory(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2f)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 24, 12, 20)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND, 1, 12, 30), new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 12, 3, 15, 0.2f)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SWORD, 8, 3, 30, 0.2f)})));
        map.put(VillagerProfession.TOOLSMITH, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_AXE), 1, 1, 12, 1, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_SHOVEL), 1, 1, 12, 1, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_PICKAXE), 1, 1, 12, 1, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.STONE_HOE), 1, 1, 12, 1, 0.2f)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.IRON_INGOT, 4, 12, 10), new TradeOffers.SellItemFactory(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2f)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 30, 12, 20), new TradeOffers.SellEnchantedToolFactory(Items.IRON_AXE, 1, 3, 10, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.IRON_SHOVEL, 2, 3, 10, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.IRON_PICKAXE, 3, 3, 10, 0.2f), new TradeOffers.SellItemFactory(new ItemStack(Items.DIAMOND_HOE), 4, 1, 3, 10, 0.2f)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DIAMOND, 1, 12, 30), new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 12, 3, 15, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SHOVEL, 5, 3, 15, 0.2f)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_PICKAXE, 13, 3, 30, 0.2f)})));
        map.put(VillagerProfession.BUTCHER, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.CHICKEN, 14, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Items.PORKCHOP, 7, 16, 2), new TradeOffers.BuyForOneEmeraldFactory(Items.RABBIT, 4, 16, 2), new TradeOffers.SellItemFactory(Items.RABBIT_STEW, 1, 1, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2), new TradeOffers.SellItemFactory(Items.COOKED_PORKCHOP, 1, 5, 16, 5), new TradeOffers.SellItemFactory(Items.COOKED_CHICKEN, 1, 8, 16, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.MUTTON, 7, 16, 20), new TradeOffers.BuyForOneEmeraldFactory(Items.BEEF, 10, 16, 20)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DRIED_KELP_BLOCK, 10, 12, 30)}, 5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SWEET_BERRIES, 10, 12, 30)})));
        map.put(VillagerProfession.LEATHERWORKER, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.LEATHER, 6, 16, 2), new TradeOffers.SellDyedArmorFactory(Items.LEATHER_LEGGINGS, 3), new TradeOffers.SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 26, 12, 10), new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 5), new TradeOffers.SellDyedArmorFactory(Items.LEATHER_BOOTS, 4, 12, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.RABBIT_HIDE, 9, 12, 20), new TradeOffers.SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30), new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HORSE_ARMOR, 6, 12, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(new ItemStack(Items.SADDLE), 6, 1, 12, 30, 0.2f), new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 30)})));
        map.put(VillagerProfession.MASON, TradeOffers.copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.CLAY_BALL, 10, 16, 2), new TradeOffers.SellItemFactory(Items.BRICK, 1, 10, 16, 1)}, 2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Blocks.STONE, 20, 16, 10), new TradeOffers.SellItemFactory(Blocks.CHISELED_STONE_BRICKS, 1, 4, 16, 5)}, 3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Blocks.GRANITE, 16, 16, 20), new TradeOffers.BuyForOneEmeraldFactory(Blocks.ANDESITE, 16, 16, 20), new TradeOffers.BuyForOneEmeraldFactory(Blocks.DIORITE, 16, 16, 20), new TradeOffers.SellItemFactory(Blocks.DRIPSTONE_BLOCK, 1, 4, 16, 10), new TradeOffers.SellItemFactory(Blocks.POLISHED_ANDESITE, 1, 4, 16, 10), new TradeOffers.SellItemFactory(Blocks.POLISHED_DIORITE, 1, 4, 16, 10), new TradeOffers.SellItemFactory(Blocks.POLISHED_GRANITE, 1, 4, 16, 10)}, 4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.QUARTZ, 12, 12, 30), new TradeOffers.SellItemFactory(Blocks.ORANGE_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.WHITE_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.BLUE_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.GRAY_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.BLACK_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.RED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.PINK_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.MAGENTA_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.LIME_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.GREEN_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.CYAN_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.PURPLE_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.YELLOW_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.BROWN_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.ORANGE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.WHITE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.BLACK_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.RED_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.PINK_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.MAGENTA_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.LIME_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.GREEN_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.CYAN_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.PURPLE_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.YELLOW_GLAZED_TERRACOTTA, 1, 1, 12, 15), new TradeOffers.SellItemFactory(Blocks.BROWN_GLAZED_TERRACOTTA, 1, 1, 12, 15)}, 5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Blocks.QUARTZ_PILLAR, 1, 1, 12, 30), new TradeOffers.SellItemFactory(Blocks.QUARTZ_BLOCK, 1, 1, 12, 30)})));
    });
}