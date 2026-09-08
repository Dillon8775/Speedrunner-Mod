package net.dillon.speedrunnermod.loot.mc.shear;

import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.function.BiConsumer;

/**
 * Stores the loot table for shearing sheep.
 */
public class SheepShearingLoot {

    public static void generateLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context, HolderGetter<LootTable> lootTables) {
        ColorCollection.zipApply(
               BuiltInLootTables.SHEAR_DYED_SHEEP,
                Blocks.WOOL,
                (dyedSheep, wool) -> context
                        .accept(dyedSheep, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ContextIntProviders.between(3, 9)).add(LootItem.lootTableItem(wool))))
        );
    }
}