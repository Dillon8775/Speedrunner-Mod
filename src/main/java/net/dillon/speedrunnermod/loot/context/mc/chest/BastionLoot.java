package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for bastions.
 */
public class BastionLoot extends GeneratableLootTable {

    public BastionLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateBridgeLoot();
        generateHoglinStableLoot();
        generateOtherLoot();
        generateTreasureLoot();
    }

    /**
     * @see BuiltInLootTables#BASTION_BRIDGE
     */
    private void generateBridgeLoot() {
        data.context().accept(
                BuiltInLootTables.BASTION_BRIDGE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#BASTION_HOGLIN_STABLE
     */
    private void generateHoglinStableLoot() {
        data.context().accept(
                BuiltInLootTables.BASTION_HOGLIN_STABLE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#BASTION_OTHER
     */
    private void generateOtherLoot() {
        data.context().accept(
                BuiltInLootTables.BASTION_OTHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#BASTION_BRIDGE
     */
    private void generateTreasureLoot() {
        data.context().accept(
                BuiltInLootTables.BASTION_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}