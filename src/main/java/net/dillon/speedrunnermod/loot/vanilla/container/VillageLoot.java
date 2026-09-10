package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for villages.
 */
public class VillageLoot extends GeneratableLootTable {

    public VillageLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateArmorerLoot();
        generateButcherLoot();
        generateCartographerLoot();
        generateDesertHouseLoot();
        generateFisherLoot();
        generateFletcherLoot();
        generateMasonLoot();
        generatePlainsHouseLoot();
        generateSavannaHouseLoot();
        generateShepherdLoot();
        generateSnowyHouseLoot();
        generateTaigaHouseLoot();
        generateTanneryLoot();
        generateTempleLoot();
        generateToolsmithLoot();
        generateWeaponsmithLoot();
    }

    private void generateArmorerLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_ARMORER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_HELMET)
                                                        .setWeight(8)
                                        )
                        )
        );
    }

    private void generateButcherLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_BUTCHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COOKED_PORKCHOP)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COOKED_BEEF)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COOKED_MUTTON)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WHEAT)
                                                        .setWeight(3)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 16)))
                                        )
                        )
        );
    }

    private void generateCartographerLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_CARTOGRAPHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(Items.OAK_LOG)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STICK)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                        )
        );
    }

    private void generateDesertHouseLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_DESERT_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LOG)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DEAD_BUSH)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                        )
        );
    }

    private void generateFisherLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_FISHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(Items.COOKED_COD)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COOKED_SALMON)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WATER_BUCKET)
                                                        .setWeight(9)
                                        )
                        )
        );
    }

    private void generateFletcherLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_FLETCHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 16)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STICK)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FEATHER)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FLINT)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                        )
        );
    }

    private void generateMasonLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_MASON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                        )
        );
    }

    private void generatePlainsHouseLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LOG)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_NUGGET)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 17)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.APPLE)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(3)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                        )
        );
    }

    private void generateSavannaHouseLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_SAVANNA_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LOG)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WATER_BUCKET)
                                                        .setWeight(9)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(4)
                                        )
                        )
        );
    }

    private void generateShepherdLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_SHEPHERD,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(Items.OAK_LOG)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WOOL.white())
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WOOL.black())
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WOOL.gray())
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WOOL.brown())
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WOOL.lightGray())
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SHEARS)
                                                        .setWeight(10)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SHEARS)
                                                        .setWeight(8)
                                        )
                        )
        );
    }

    private void generateSnowyHouseLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_SNOWY_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(Items.STRIPPED_SPRUCE_LOG)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FURNACE)
                                                        .setWeight(5)
                                        )
                        )
        );
    }

    private void generateTaigaHouseLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.DEAD_SPEEDRUNNER_LOG)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPRUCE_LOG)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NUGGET)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 18)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SWEET_BERRIES)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                        )
        );
    }

    private void generateTanneryLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_TANNERY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 5))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER_HELMET)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER_CHESTPLATE)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER_LEGGINGS)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER_BOOTS)
                                                        .setWeight(3)
                                        )
                        )
        );
    }

    private void generateTempleLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_TEMPLE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LAPIS_LAZULI)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                        )
        );
    }

    private void generateToolsmithLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.FLINT_AND_STEEL)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(10, 14)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(13)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 10)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STICK)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SHOVEL)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_HOE)
                                                        .setWeight(3)
                                        )
                        )
        );
    }

    private void generateWeaponsmithLoot() {
        data.output().accept(
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SPEAR)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.FLINT_AND_STEEL)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(10, 14)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 8))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(13)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HAY_BLOCK)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SWORD)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_HELMET)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LEGGINGS)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR)
                                                        .setWeight(5)
                                        )
                        )
        );
    }
}