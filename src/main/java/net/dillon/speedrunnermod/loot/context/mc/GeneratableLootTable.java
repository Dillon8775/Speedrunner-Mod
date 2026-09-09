package net.dillon.speedrunnermod.loot.context.mc;

/**
 * Stores data required for making loot tables.
 */
public abstract class GeneratableLootTable {
    public LootTableData data;

    public GeneratableLootTable(final LootTableData data) {
        this.data = data;
    }

    /**
     * Generates the loot for a specified class.
     */
    public abstract void generateLoot();
}