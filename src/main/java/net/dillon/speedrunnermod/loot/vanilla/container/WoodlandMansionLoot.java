package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for woodland mansions.
 */
public class WoodlandMansionLoot extends GeneratableLootTable {

    public WoodlandMansionLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.WOODLAND_MANSION,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.LEAD)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NAME_TAG)
                                                        .setWeight(2)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(13)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(15)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(20)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE)
                                                        .setWeight(25)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(18)
                                                        .apply(enchantWithLevelsAndKey(EnchantmentTags.ON_RANDOM_LOOT, 35))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HOE)
                                                        .setWeight(5)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 4))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 10))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(8)
                                                        .apply(setCount(5, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(7)
                                                        .apply(setCount(5, 15))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BUCKET)
                                                        .setWeight(6)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(3))
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 16))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.FLESH_BLOCK)
                                                        .setWeight(10)
                                                        .apply(setCount(1, 5))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.COOKED_FLESH)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 9))
                                        )
                        )
        );
    }
}