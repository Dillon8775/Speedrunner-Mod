package net.dillon.speedrunnermod.loot.vanilla.archaeology;

import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for archaeology.
 */
public class ArchaeologyLoot extends GeneratableLootTable {

    public ArchaeologyLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateDesertWellLoot();
        generateDesertPyramidLoot();
        generateTrailRuinsCommonLoot();
        generateTrailRuinsRareLoot();
        generateOceanRuinWarmLoot();
        generateOceanRuinColdLoot();
    }

    private void generateDesertWellLoot() {
        data.output().accept(
                BuiltInLootTables.DESERT_WELL_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateDesertPyramidLoot() {
        data.output().accept(
                BuiltInLootTables.DESERT_PYRAMID_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateTrailRuinsCommonLoot() {
        data.output().accept(
                BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateTrailRuinsRareLoot() {
        data.output().accept(
                BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateOceanRuinWarmLoot() {
        data.output().accept(
                BuiltInLootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateOceanRuinColdLoot() {
        data.output().accept(
                BuiltInLootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}