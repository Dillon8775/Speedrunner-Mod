package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for igloos.
 */
public class IglooLoot extends GeneratableLootTable {

    public IglooLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#IGLOO_CHEST
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.IGLOO_CHEST,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}