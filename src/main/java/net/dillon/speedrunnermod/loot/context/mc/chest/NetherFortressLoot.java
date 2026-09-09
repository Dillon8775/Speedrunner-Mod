package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for nether fortresses.
 */
public class NetherFortressLoot extends GeneratableLootTable {

    public NetherFortressLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#NETHER_BRIDGE
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.NETHER_BRIDGE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}