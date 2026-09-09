package net.dillon.speedrunnermod.loot.context.mc.shear;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot table for shearing sheep.
 */
public class SheepShearingLoot extends GeneratableLootTable {

    public SheepShearingLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        ColorCollection.zipApply(
                BuiltInLootTables.SHEAR_DYED_SHEEP,
                Blocks.WOOL,
                (dyedSheep, wool) ->
                        data.context()
                                .accept(
                                        dyedSheep,
                                        LootTable.lootTable()
                                                .withPool(
                                                        LootPool.lootPool()
                                                                .setRolls(ContextIntProviders.between(3, 9))
                                                                .add(LootItem.lootTableItem(wool)))
                                )
        );
    }
}