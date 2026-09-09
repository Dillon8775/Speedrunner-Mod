package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * Stores the loot tables for trial chambers.
 */
public class TrialChamberLoot extends GeneratableLootTable {

    public TrialChamberLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateCorridorLoot();
        generateEntranceLoot();
        generateIntersectionLoot();
        generateIntersectionBarrelLoot();
        generateRewardCommonLoot();
        generateRewardOminousCommonLoot();
        generateRewardOminousRareLoot();
        generateRewardOminousUniqueLoot();
        generateRewardRareLoot();
        generateRewardUniqueLoot();
        generateSupplyLoot();
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_CORRIDOR
     */
    private void generateCorridorLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_CORRIDOR,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_ENTRANCE
     */
    private void generateEntranceLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_ENTRANCE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_INTERSECTION
     */
    private void generateIntersectionLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_INTERSECTION,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_INTERSECTION_BARREL
     */
    private void generateIntersectionBarrelLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_INTERSECTION_BARREL,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_REWARD_COMMON
     */
    private void generateRewardCommonLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_COMMON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON
     */
    private void generateRewardOminousCommonLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_REWARD_OMINOUS_RARE
     */
    private void generateRewardOminousRareLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE
     */
    private void generateRewardOminousUniqueLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_REWARD_RARE
     */
    private void generateRewardRareLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_REWARD_UNIQUE
     */
    private void generateRewardUniqueLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#TRIAL_CHAMBERS_SUPPLY
     */
    private void generateSupplyLoot() {
        data.context().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_SUPPLY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}