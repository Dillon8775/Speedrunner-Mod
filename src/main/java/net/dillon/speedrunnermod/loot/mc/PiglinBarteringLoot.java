package net.dillon.speedrunnermod.loot.mc;

import net.dillon.speedrunnermod.loot.ModPiglinBarterLootTables;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

/**
 * Stores the loot table for piglin bartering.
 */
public class PiglinBarteringLoot {

    public static void generateLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context, HolderGetter<Enchantment> enchantments) {
        context.accept(
                ModPiglinBarterLootTables.MC_PIGLIN_BARTERING,
                LootTable.lootTable()
        );
    }
}