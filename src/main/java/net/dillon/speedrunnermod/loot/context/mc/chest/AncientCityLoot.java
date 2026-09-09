package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for ancient cities.
 */
public class AncientCityLoot extends GeneratableLootTable {

    public AncientCityLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#ANCIENT_CITY
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.ANCIENT_CITY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}