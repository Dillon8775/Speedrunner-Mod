package net.dillon.speedrunnermod.loot.vanilla.fishing;

import net.dillon.speedrunnermod.component.ModEnchantments;
import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.predicates.entity.FishingHookPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for fishing.
 */
public class FishingLoot extends GeneratableLootTable {

    public FishingLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateJunkLoot();
        generateTreasureLoot();
        generateFishingLoot();

        Holder<LootTable> junkTable = data.provider().lookupOrThrow(Registries.LOOT_TABLE).getOrThrow(BuiltInLootTables.FISHING_JUNK);
        Holder<LootTable> treasureTable = data.provider().lookupOrThrow(Registries.LOOT_TABLE).getOrThrow(BuiltInLootTables.FISHING_TREASURE);
        Holder<LootTable> fishTable = data.provider().lookupOrThrow(Registries.LOOT_TABLE).getOrThrow(BuiltInLootTables.FISHING_FISH);

        data.output().accept(
                BuiltInLootTables.FISHING,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                NestedLootTable.lootTableReference(junkTable)
                                                        .setWeight(10)
                                                        .setQuality(-2))
                                        .add(
                                                NestedLootTable.lootTableReference(treasureTable)
                                                        .setWeight(8)
                                                        .setQuality(3)
                                                        .when(
                                                                LootItemEntityPropertyCondition.hasProperties(
                                                                        LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().fishingHook(
                                                                                FishingHookPredicate.inOpenWater(true)
                                                                        )
                                                                )
                                                        )
                                        )
                                        .add(
                                                NestedLootTable.lootTableReference(fishTable)
                                                        .setWeight(25)
                                                        .setQuality(-2)
                                        )
                        )
        );
    }

    private void generateJunkLoot() {
        data.output().accept(
                BuiltInLootTables.FISHING_JUNK,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.LILY_PAD)
                                                        .setWeight(6)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER)
                                                        .setWeight(8)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(7)
                                                        .apply(SetPotionFunction.setPotion(Potions.WATER_BREATHING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BOOTS)
                                                        .setWeight(9)
                                                        .apply(setDamage(0.1F, 0.4F))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(7)
                                                        .apply(setCount(2, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                                        .setWeight(8)
                                                        .apply(setDamage(0.1F, 0.3F))
                                                        .apply(withEnchantment(ModEnchantments.DASH))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(4)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(2)
                                        )
                        )
        );
    }

    private void generateTreasureLoot() {
        data.output().accept(
                BuiltInLootTables.FISHING_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(20)
                                                        .apply(enchantWithLevels(35))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOW)
                                                        .setWeight(10)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FISHING_ROD)
                                                        .setWeight(7)
                                                        .apply(enchantWithLevelsAndKey(EnchantmentTags.ON_RANDOM_LOOT, 33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(5)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NAUTILUS_SHELL)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NAME_TAG)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(2)
                                                        .when(LocationCheck.checkLocation(
                                                                        new LocationPredicate.Builder()
                                                                                .setBiomes(HolderSet.direct(
                                                                                        data.biomes().getOrThrow(Biomes.DEEP_OCEAN),
                                                                                        data.biomes().getOrThrow(Biomes.DEEP_FROZEN_OCEAN),
                                                                                        data.biomes().getOrThrow(Biomes.DEEP_COLD_OCEAN))
                                                                                )
                                                                )
                                                        )
                                        )
                        )
        );
    }

    private void generateFishingLoot() {
        data.output().accept(
                BuiltInLootTables.FISHING_FISH,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.COOKED_COD)
                                                        .setWeight(20)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COOKED_SALMON)
                                                        .setWeight(20)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TROPICAL_FISH)
                                                        .setWeight(8)
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PUFFERFISH)
                                                        .setWeight(12)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 7))
                                        )
                        )
        );
    }
}