package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.StructureTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraft.world.level.saveddata.maps.MapDecorationTypes;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import org.jspecify.annotations.Nullable;

import static net.dillon.speedrunnermod.mixin.accessor.VanillaChestLootInvoker.discardIfNotValidMap;

/**
 * Stores the loot tables for abandoned camps.
 */
public class AbandonedCampLoot extends GeneratableLootTable {

    public AbandonedCampLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateBarrelLoot();
        generateCommonLoot();
        generateSecretLoot();
    }

    private void generateBarrelLoot() {
        data.output().accept(
                BuiltInLootTables.ABANDONED_CAMP_BARREL,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(4, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(6)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRAW_BED)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(5)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER)
                                                        .setWeight(5)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.RABBIT_HIDE)
                                                        .setWeight(4)
                                                        .apply(setCount(1, 5))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COBWEB)
                                                        .setWeight(4)
                                                        .apply(setCount(1, 5))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BUNDLE)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COPPER_PICKAXE)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FISHING_ROD)
                                                        .setWeight(5)
                                        )
                        )
        );
    }

    private void generateCommonLoot() {
        data.output().accept(
                BuiltInLootTables.ABANDONED_CAMP_COMMON_CHEST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(4, 6))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(10)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_SPEEDRUNNER_HELMET)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(8)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GUNPOWDER)
                                                        .setWeight(5)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COMPASS)
                                                        .setWeight(4)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER)
                                                        .setWeight(5)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FISHING_ROD)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BUNDLE)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(4)
                                                        .apply(setCount(1, 3))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.BOW)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CROSSBOW)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BUCKET)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_AXE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_HELMET)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SPEAR)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPYGLASS)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_BAMBOO_JUNGLE_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.bamboo_camp_map",
                                                        data.biomes().getOrThrow(Biomes.BAMBOO_JUNGLE)
                                                )
                                        )
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_CHERRY_GROVE_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.cherry_grove_camp_map",
                                                        data.biomes().getOrThrow(Biomes.CHERRY_GROVE)
                                                )
                                        )
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_BIRCH_FOREST_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.birch_forest_camp_map",
                                                        data.biomes().getOrThrow(Biomes.BIRCH_FOREST)
                                                )
                                        )
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_DAPPLED_FOREST_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.dappled_forest_camp_map",
                                                        data.biomes().getOrThrow(Biomes.DAPPLED_FOREST)
                                                )
                                        )
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_FLOWER_FOREST_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.flower_forest_camp_map",
                                                        data.biomes().getOrThrow(Biomes.FLOWER_FOREST)
                                                )
                                        )
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_PALE_GARDEN_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.pale_garden_camp_map",
                                                        data.biomes().getOrThrow(Biomes.PALE_GARDEN)
                                                )
                                        )
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_SWAMP_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.swamp_camp_map",
                                                        data.biomes().getOrThrow(Biomes.SWAMP)
                                                )
                                        )
                                        .add(
                                                this.explorationMapItemExcludingBiome(
                                                        StructureTags.ON_ABANDONED_CAMP_WINDSWEPT_FOREST_MAPS,
                                                        MapDecorationTypes.ABANDONED_CAMP,
                                                        Items.ABANDONED_CAMP_MAP,
                                                        "filled_map.windswept_forest_camp_map",
                                                        data.biomes().getOrThrow(Biomes.WINDSWEPT_FOREST)
                                                )
                                        )
                        )
        );
    }

    private void generateSecretLoot() {
        data.output().accept(
                BuiltInLootTables.ABANDONED_CAMP_SECRET_CHEST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(8)
                                                        .apply(enchantWithLevels(24))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(8)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_HEALING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(6)
                                                        .apply(SetPotionFunction.setPotion(Potions.SWIFTNESS))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_HELMET)
                                                        .setWeight(6)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(6)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(4, 6))
                                        .add(
                                                LootItem.lootTableItem(Items.MAP)
                                                        .setWeight(10)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COPPER_INGOT)
                                                        .setWeight(6)
                                                        .apply(setCount(3, 8))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 2))
                                        .add(
                                                LootItem.lootTableItem(Items.TIPPED_ARROW)
                                                        .apply(setCount(2, 9))
                                                        .apply(SetPotionFunction.setPotion(Potions.HARMING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOW)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CROSSBOW)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LEGGINGS)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SWORD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_HELMET)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(this.explorationMapItem(StructureTags.ON_ANCIENT_CITY_MAPS, MapDecorationTypes.ANCIENT_CITY, Items.BURIED_ANCIENT_CITY_MAP))
                                        .add(this.explorationMapItem(StructureTags.ON_BURIED_TRIAL_CHAMBERS_MAPS, MapDecorationTypes.TRIAL_CHAMBERS, Items.BURIED_TRIAL_CHAMBERS_MAP))
                                        .add(this.explorationMapItem(StructureTags.ON_MINESHAFT_MAPS, MapDecorationTypes.MINESHAFT, Items.BURIED_MINESHAFT_MAP))
                                        .add(this.explorationMapItem(StructureTags.ON_DESERT_PYRAMID_MAPS, MapDecorationTypes.DESERT_PYRAMID, Items.DESERT_PYRAMID_MAP))
                                        .add(this.explorationMapItem(StructureTags.ON_JUNGLE_PYRAMID_MAPS, MapDecorationTypes.JUNGLE_TEMPLE, Items.JUNGLE_PYRAMID_MAP))
                                        .add(this.explorationMapItem(StructureTags.ON_OCEAN_RUIN_WARM_MAPS, MapDecorationTypes.OCEAN_RUIN_WARM, Items.WARM_OCEAN_RUINS_MAP))
                                        .add(this.explorationMapItem(StructureTags.ON_WOODLAND_MANSION_MAPS, MapDecorationTypes.WOODLAND_MANSION, Items.WOODLAND_MANSION_MAP))
                        )
        );
    }

    private UniformContainerBase.Builder<?> explorationMapItemExcludingBiome(final TagKey<Structure> structureTag, final Holder<MapDecorationType> decoration, final Item mapItem, final String translationKey, final Holder<Biome> excludedBiome) {
        return this.explorationMapItem(structureTag, decoration, mapItem, translationKey)
                .when(
                        LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiomes(HolderSet.direct(excludedBiome))).invert()
                );
    }

    private UniformContainerBase.Builder<?> explorationMapItem(final TagKey<Structure> structureTag, final Holder<MapDecorationType> decoration, final Item mapItem) {
        return this.explorationMapItem(structureTag, decoration, mapItem, null);
    }

    private UniformContainerBase.Builder<?> explorationMapItem(final TagKey<Structure> structureTag, final Holder<MapDecorationType> decoration, final Item mapItem, final @Nullable String translationKey) {
        UniformContainerBase.Builder<?> entry = LootItem.lootTableItem(mapItem).setWeight(1);
        if (translationKey != null) {
            entry = entry.apply(SetNameFunction.setName(Component.translatable(translationKey), SetNameFunction.Target.ITEM_NAME));
        }

        return entry.apply(
                        ExplorationMapFunction.makeExplorationMap(data.structures().getOrThrow(structureTag)).setMapDecoration(decoration).setSkipKnownStructures(true)
                )
                .apply(discardIfNotValidMap());
    }
}