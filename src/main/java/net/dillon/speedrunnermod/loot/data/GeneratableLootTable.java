package net.dillon.speedrunnermod.loot.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import static net.dillon.speedrunnermod.main.SpeedrunnerMod.ofSpeedrunnerMod;

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

    /**
     * Creates a new speedrunner mod loot table.
     */
    public static ResourceKey<LootTable> createLootTable(final String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, ofSpeedrunnerMod(path));
    }
}