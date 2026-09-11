package net.dillon.speedrunnermod.loot.vanilla.barter;

import net.dillon.speedrunnermod.block.ModBlocks;
import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.dillon.speedrunnermod.tag.ModEnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot table for piglin bartering.
 */
public class PiglinBarteringLoot extends GeneratableLootTable {

    public PiglinBarteringLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.PIGLIN_BARTERING,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_PEARL)
                                                        .setWeight(18)
                                                        .apply(setCount(6, 10))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(15)
                                                        .apply(setCount(7, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .setWeight(12)
                                                        .apply(setCount(8, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(11)
                                                        .apply(setCount(3, 5))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CRYING_OBSIDIAN)
                                                        .setWeight(10)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FIRE_CHARGE)
                                                        .setWeight(10)
                                                        .apply(setCount(2, 5))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModBlocks.SPEEDRUNNER_PLANKS)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(8)
                                                        .apply(setCount(9, 16))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(8)
                                                        .apply(setCount(9, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.PIGLIN_PORK)
                                                        .setWeight(7)
                                                        .apply(setCount(7, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GRAVEL)
                                                        .setWeight(7)
                                                        .apply(setCount(4, 13))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(7)
                                                        .apply(SetPotionFunction.setPotion(Potions.FIRE_RESISTANCE))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BLACKSTONE)
                                                        .setWeight(6)
                                                        .apply(setCount(11, 22))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WARPED_PLANKS)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CRIMSON_PLANKS)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SOUL_SAND)
                                                        .setWeight(6)
                                                        .apply(setCount(8, 16))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BOOTS)
                                                        .setWeight(6)
                                                        .apply(randomEnchantment(ModEnchantmentTags.FROM_PIGLIN_BARTERING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(5)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(5)
                                                        .apply(randomEnchantment(ModEnchantmentTags.FROM_PIGLIN_BARTERING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NUGGET)
                                                        .setWeight(4)
                                                        .apply(setCount(9, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(3)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(2)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(2)
                                        )
                        )
        );
    }
}