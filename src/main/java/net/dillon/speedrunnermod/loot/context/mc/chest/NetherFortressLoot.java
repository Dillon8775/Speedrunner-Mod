package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.component.ModEnchantments;
import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for nether fortresses.
 */
public class NetherFortressLoot extends GeneratableLootTable {

    public NetherFortressLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#NETHER_BRIDGE
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.NETHER_BRIDGE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 4))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FLINT_AND_STEEL)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHER_WART)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(6)
                                                        .apply(new EnchantRandomlyFunction.Builder()
                                                                .withEnchantment(
                                                                        data.enchantments().getOrThrow(ModEnchantments.WITHERED)
                                                                )
                                                        )
                                        )
                        )
        );
    }
}