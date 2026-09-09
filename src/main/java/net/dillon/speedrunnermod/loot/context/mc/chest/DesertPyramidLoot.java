package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for desert pyramids.
 */
public class DesertPyramidLoot extends GeneratableLootTable {

    public DesertPyramidLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#DESERT_PYRAMID
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.DESERT_PYRAMID,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}