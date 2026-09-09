package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for pillager outposts.
 */
public class PillagerOutpostLoot extends GeneratableLootTable {

    public PillagerOutpostLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#PILLAGER_OUTPOST
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.PILLAGER_OUTPOST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}