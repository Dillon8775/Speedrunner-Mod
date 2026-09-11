package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for desert pyramids.
 */
public class DesertPyramidLoot extends GeneratableLootTable {

    public DesertPyramidLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.DESERT_PYRAMID,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 4))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(10)
                                                        .apply(enchantWithLevels(24))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(7)
                                                        .apply(randomSpeedrunnerBookEnchantment())
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(12)
                                                        .apply(setCount(4, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(10)
                                                        .apply(setCount(9, 13))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BONE)
                                                        .setWeight(5)
                                                        .apply(setCount(4, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPIDER_EYE)
                                                        .setWeight(4)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                        .setWeight(4)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LOG)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(7)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(15)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                EmptyLootItem.emptyItem()
                                                        .setWeight(15)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(4))
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(5)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(8)
                                                        .apply(setCount(9, 15))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LOG)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SAND)
                                                        .setWeight(4)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GUNPOWDER)
                                                        .setWeight(4)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BONE)
                                                        .setWeight(3)
                                                        .apply(setCount(2, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                        .setWeight(3)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(6)
                                        )
                        )
        );
    }
}