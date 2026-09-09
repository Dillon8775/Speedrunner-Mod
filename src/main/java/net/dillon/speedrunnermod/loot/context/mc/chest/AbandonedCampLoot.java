package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

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

    /**
     * @see BuiltInLootTables#ABANDONED_CAMP_BARREL
     */
    private void generateBarrelLoot() {
        data.context().accept(
                BuiltInLootTables.ABANDONED_CAMP_BARREL,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#ABANDONED_CAMP_COMMON_CHEST
     */
    private void generateCommonLoot() {
        data.context().accept(
                BuiltInLootTables.ABANDONED_CAMP_COMMON_CHEST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#ABANDONED_CAMP_SECRET_CHEST
     */
    private void generateSecretLoot() {
        data.context().accept(
                BuiltInLootTables.ABANDONED_CAMP_SECRET_CHEST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}