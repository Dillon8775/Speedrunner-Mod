package net.dillon.speedrunnermod.loot.mc;

import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

/**
 * Stores data required for making loot tables.
 */
public record LootTableData(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context, HolderGetter<Enchantment> enchantments, HolderGetter<Structure> structures) {
}