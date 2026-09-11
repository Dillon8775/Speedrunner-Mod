package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for ruined portals.
 */
public class RuinedPortalLoot extends GeneratableLootTable {

    public RuinedPortalLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.RUINED_PORTAL,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.FLINT_AND_STEEL)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .apply(setCount(5, 8))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_AXE)
                                                        .apply(enchantWithLevels(33))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_PICKAXE)
                                                        .apply(enchantWithLevels(33))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_SWORD)
                                                        .apply(withEnchantment(Enchantments.LOOTING))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(4, 8))
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_PEARL)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(21)
                                                        .apply(setCount(7, 15))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GLOWSTONE)
                                                        .setWeight(1)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(8)
                                                        .apply(setCount(4, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(9)
                                                        .apply(setCount(9, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NUGGET)
                                                        .setWeight(8)
                                                        .apply(setCount(9, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FIRE_CHARGE)
                                                        .setWeight(18)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_NUGGET)
                                                        .setWeight(14)
                                                        .apply(setCount(9, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(20)
                                                        .apply(setCount(9, 27))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(25)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(9)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                        .setWeight(25)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_HOE)
                                                        .setWeight(2)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_SHOVEL)
                                                        .setWeight(3)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_BOOTS)
                                                        .setWeight(3)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_HELMET)
                                                        .setWeight(3)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_LEGGINGS)
                                                        .setWeight(3)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))

                                        )
                        )
        );
    }
}