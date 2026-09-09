package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for abandoned mineshafts.
 */
public class AbandonedMineshaftLoot extends GeneratableLootTable {

    public AbandonedMineshaftLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#ABANDONED_MINESHAFT
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.ABANDONED_MINESHAFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}