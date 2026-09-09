package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for end cities.
 */
public class EndCityLoot extends GeneratableLootTable {

    public EndCityLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#END_CITY_TREASURE
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.END_CITY_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}