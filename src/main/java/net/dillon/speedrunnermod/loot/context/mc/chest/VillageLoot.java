package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

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

    /**
     * @see BuiltInLootTables#VILLAGE_ARMORER
     */
    private void generateArmorerLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_ARMORER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_BUTCHER
     */
    private void generateButcherLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_BUTCHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_CARTOGRAPHER
     */
    private void generateCartographerLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_CARTOGRAPHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_DESERT_HOUSE
     */
    private void generateDesertHouseLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_DESERT_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_FISHER
     */
    private void generateFisherLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_FISHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_FLETCHER
     */
    private void generateFletcherLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_FLETCHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_MASON
     */
    private void generateMasonLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_MASON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_PLAINS_HOUSE
     */
    private void generatePlainsHouseLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_SAVANNA_HOUSE
     */
    private void generateSavannaHouseLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_SAVANNA_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_SHEPHERD
     */
    private void generateShepherdLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_SHEPHERD,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_SNOWY_HOUSE
     */
    private void generateSnowyHouseLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_SNOWY_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_TAIGA_HOUSE
     */
    private void generateTaigaHouseLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_TANNERY
     */
    private void generateTanneryLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_TANNERY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_TEMPLE
     */
    private void generateTempleLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_TEMPLE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_TOOLSMITH
     */
    private void generateToolsmithLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    /**
     * @see BuiltInLootTables#VILLAGE_WEAPONSMITH
     */
    private void generateWeaponsmithLoot() {
        data.context().accept(
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}