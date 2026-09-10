package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for jungle temples.
 */
public class JungleTempleLoot extends GeneratableLootTable {

    public JungleTempleLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.JUNGLE_TEMPLE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
        generateDispenserLoot();
    }

    private void generateDispenserLoot() {
        data.output().accept(
                BuiltInLootTables.JUNGLE_TEMPLE_DISPENSER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}