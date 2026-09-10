package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
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

    private void generateBarrelLoot() {
        data.output().accept(
                BuiltInLootTables.ABANDONED_CAMP_BARREL,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateCommonLoot() {
        data.output().accept(
                BuiltInLootTables.ABANDONED_CAMP_COMMON_CHEST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateSecretLoot() {
        data.output().accept(
                BuiltInLootTables.ABANDONED_CAMP_SECRET_CHEST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}