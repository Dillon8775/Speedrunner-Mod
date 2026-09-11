package net.dillon.speedrunnermod.loot.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

/**
 * Stores required data fields for making loot tables.
 */
public record LootTableData(
        HolderLookup.Provider provider,
        BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output,
        HolderGetter<Enchantment> enchantments,
        HolderGetter<Structure> structures,
        HolderGetter<Potion> potions,
        HolderGetter<Biome> biomes
) {
}