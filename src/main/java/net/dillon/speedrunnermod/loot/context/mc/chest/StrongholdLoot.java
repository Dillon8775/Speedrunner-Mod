package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.dillon.speedrunnermod.tag.ModEnchantmentTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for strongholds.
 */
public class StrongholdLoot extends GeneratableLootTable {

    public StrongholdLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateCorridorLoot();
        generateCrossingLoot();
        generateLibraryLoot();
    }

    /**
     * @see BuiltInLootTables#STRONGHOLD_CORRIDOR
     */
    private void generateCorridorLoot() {
        data.context().accept(
                BuiltInLootTables.STRONGHOLD_CORRIDOR,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_EYE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_PEARL)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 21)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SWORD)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LEGGINGS)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MUSIC_DISC_OTHERSIDE)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(8)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(EnchantmentTags.ON_RANDOM_LOOT)
                                                                )
                                                        )
                                        )
                        )
        );
    }

    /**
     * @see BuiltInLootTables#STRONGHOLD_CROSSING
     */
    private void generateCrossingLoot() {
        data.context().accept(
                BuiltInLootTables.STRONGHOLD_CROSSING,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 4))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(25)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 18)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(11)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(10)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(4)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                        )
        );
    }

    /**
     * @see BuiltInLootTables#STRONGHOLD_LIBRARY
     */
    private void generateLibraryLoot() {
        data.context().accept(
                BuiltInLootTables.STRONGHOLD_LIBRARY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .apply(new EnchantRandomlyFunction.Builder()
                                                                .withEnchantment(
                                                                        data.enchantments().getOrThrow(Enchantments.FORTUNE)
                                                                )
                                                        )
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 10))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(20)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(11)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GUNPOWDER)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PAPER)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                        )
        );
    }
}