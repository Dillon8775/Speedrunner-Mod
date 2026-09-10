package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.dillon.speedrunnermod.tag.ModEnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for abandoned mineshafts.
 */
public class AbandonedMineshaftLoot extends GeneratableLootTable {

    public AbandonedMineshaftLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#ABANDONED_MINESHAFT
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.ABANDONED_MINESHAFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(18)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(16)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GLOW_BERRIES)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(10)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(7)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments())
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(9)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PICKAXE)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                EmptyLootItem.emptyItem()
                                                        .setWeight(5)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 4))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREAD)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 17)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LAPIS_LAZULI)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 16)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(6)
                                        )
                        )
        );
    }
}