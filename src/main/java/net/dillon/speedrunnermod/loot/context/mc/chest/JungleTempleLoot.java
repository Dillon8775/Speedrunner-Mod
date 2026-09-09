package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
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
        generateTempleLoot();
        generateDispenserLoot();
    }

    /**
     * @see BuiltInLootTables#JUNGLE_TEMPLE
     */
    private void generateTempleLoot() {
        data.context().accept(
                BuiltInLootTables.JUNGLE_TEMPLE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#JUNGLE_TEMPLE_DISPENSER
     */
    private void generateDispenserLoot() {
        data.context().accept(
                BuiltInLootTables.JUNGLE_TEMPLE_DISPENSER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}