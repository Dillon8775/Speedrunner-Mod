package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for strongholds.
 */
public class StrongholdLoot extends GeneratableLootTable {

    public StrongholdLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateCorridorLoot();
        generateCrossingLoot();
        generateLibraryLoot();
    }

    private void generateCorridorLoot() {
        data.output().accept(
                BuiltInLootTables.STRONGHOLD_CORRIDOR,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_EYE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_PEARL)
                                                        .setWeight(15)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(15)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(15)
                                                        .apply(setCount(4, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(15)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(9)
                                                        .apply(setCount(9, 21))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(8)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SWORD)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LEGGINGS)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MUSIC_DISC_OTHERSIDE)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(8)
                                                        .apply(enchantWithLevelsAndKey(EnchantmentTags.ON_RANDOM_LOOT, 33))
                                        )
                        )
        );
    }

    private void generateCrossingLoot() {
        data.output().accept(
                BuiltInLootTables.STRONGHOLD_CROSSING,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 4))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(15)
                                                        .apply(setCount(1, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(25)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(15)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(15)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(11)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(14)
                                                        .apply(setCount(2, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(8)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(11)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(10)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(4)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                        )
        );
    }

    private void generateLibraryLoot() {
        data.output().accept(
                BuiltInLootTables.STRONGHOLD_LIBRARY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .apply(withEnchantment(Enchantments.FORTUNE))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 10))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(20)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(11)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GUNPOWDER)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PAPER)
                                                        .setWeight(7)
                                                        .apply(setCount(2, 7))
                                        )
                        )
        );
    }
}