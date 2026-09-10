package net.dillon.speedrunnermod.loot.vanilla.fishing;

import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

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

        data.output().accept(
                BuiltInLootTables.FISHING,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateJunkLoot() {
        data.output().accept(
                BuiltInLootTables.FISHING_JUNK,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateTreasureLoot() {
        data.output().accept(
                BuiltInLootTables.FISHING_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateFishingLoot() {
        data.output().accept(
                BuiltInLootTables.FISHING_FISH,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}