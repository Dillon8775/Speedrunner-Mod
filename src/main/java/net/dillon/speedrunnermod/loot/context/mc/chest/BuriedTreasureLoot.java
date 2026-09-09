package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for buried treasures.
 */
public class BuriedTreasureLoot extends GeneratableLootTable {

    public BuriedTreasureLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#BURIED_TREASURE
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.BURIED_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}