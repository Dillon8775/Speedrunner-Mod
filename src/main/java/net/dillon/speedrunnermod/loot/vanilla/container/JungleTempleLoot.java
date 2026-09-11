package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.PotionTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.functions.SetRandomPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for jungle temples.
 */
public class JungleTempleLoot extends GeneratableLootTable {

    public JungleTempleLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.JUNGLE_TEMPLE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 6))
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(7)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(10)
                                                        .apply(enchantWithLevelsAndKey(EnchantmentTags.ON_RANDOM_LOOT, 33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(12)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR)
                                                        .setWeight(4)
                                        )
                        )
        );
        generateDispenserLoot();
    }

    private void generateDispenserLoot() {
        data.output().accept(
                BuiltInLootTables.JUNGLE_TEMPLE_DISPENSER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 2))
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TIPPED_ARROW)
                                                        .setWeight(7)
                                                        .apply(setCount(2, 6))
                                                        .apply(SetRandomPotionFunction.fromTagKey(
                                                                data.potions().getOrThrow(PotionTags.TRADEABLE))
                                                        )
                                        )
                        )
        );
    }
}