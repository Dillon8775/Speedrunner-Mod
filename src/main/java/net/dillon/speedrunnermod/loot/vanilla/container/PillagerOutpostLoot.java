package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for pillager outposts.
 */
public class PillagerOutpostLoot extends GeneratableLootTable {

    public PillagerOutpostLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.PILLAGER_OUTPOST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.DARK_OAK_LOG)
                                                        .apply(setCount(3, 8))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 2))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CROSSBOW)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CROSSBOW)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CARROT)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(2)
                                                        .apply(setCount(2, 9))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(5)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(5)
                                                        .apply(setCount(3, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE)
                                                        .setWeight(4)
                                        )
                        )
        );
    }
}