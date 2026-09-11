package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.functions.SetStewEffectFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for shipwrecks.
 */
public class ShipwreckLoot extends GeneratableLootTable {

    public ShipwreckLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateSupplyLoot();
        generateTreasureLoot();
    }

    private void generateSupplyLoot() {
        data.output().accept(
                BuiltInLootTables.SHIPWRECK_SUPPLY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.PUFFERFISH)
                                                        .apply(setCount(1, 3))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 10))
                                        .add(
                                                LootItem.lootTableItem(Items.SUSPICIOUS_STEW)
                                                        .setWeight(10)
                                                        .apply(
                                                                SetStewEffectFunction.stewEffect()
                                                                        .withEffect(MobEffects.NIGHT_VISION, ContextIntProviders.between(8, 20))
                                                                        .withEffect(MobEffects.JUMP_BOOST, ContextIntProviders.between(7, 10))
                                                                        .withEffect(MobEffects.SATURATION, ContextIntProviders.between(10, 15))
                                                                        .withEffect(MobEffects.REGENERATION, ContextIntProviders.between(10, 20))
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CARROT)
                                                        .setWeight(11)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TNT)
                                                        .setWeight(9)
                                                        .apply(setCount(2, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WHEAT)
                                                        .setWeight(7)
                                                        .apply(setCount(8, 21))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PAPER)
                                                        .setWeight(6)
                                                        .apply(setCount(3, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GUNPOWDER)
                                                        .setWeight(5)
                                                        .apply(setCount(3, 11))
                                        )
                                        .add(
                                              LootItem.lootTableItem(Items.POTATO)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POISONOUS_POTATO)
                                                        .setWeight(5)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                        .setWeight(5)
                                                        .apply(setCount(5, 24))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PUMPKIN)
                                                        .setWeight(3)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BAMBOO)
                                                        .setWeight(2)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_HELMET)
                                                        .setWeight(3)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments()))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_CHESTPLATE)
                                                        .setWeight(3)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments()))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_LEGGINGS)
                                                        .setWeight(3)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments()))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BOOTS)
                                                        .setWeight(3)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments()))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COPPER_NAUTILUS_ARMOR)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NAUTILUS_ARMOR)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_NAUTILUS_ARMOR)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_NAUTILUS_ARMOR)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NAUTILUS_ARMOR)
                                                        .setWeight(10)
                                        )
                        )
        );
    }

    private void generateTreasureLoot() {
        data.output().accept(
                BuiltInLootTables.SHIPWRECK_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(0, 1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 4))
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(7)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(13)
                                                        .apply(setCount(2, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(12)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(11)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(9)
                                                        .apply(setCount(9, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(6)
                                                        .apply(setCount(1, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE)
                                                        .setWeight(3)
                                                        .apply(setCount(2, 6))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(6)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(15)
                                                        .apply(setCount(7, 13))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NUGGET)
                                                        .setWeight(11)
                                                        .apply(setCount(9, 27))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(11)
                                                        .apply(setCount(9, 27))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LAPIS_LAZULI)
                                                        .setWeight(8)
                                                        .apply(setCount(6, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COPPER_NAUTILUS_ARMOR)
                                                        .setWeight(2)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NAUTILUS_ARMOR)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_NAUTILUS_ARMOR)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_NAUTILUS_ARMOR)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NAUTILUS_ARMOR)
                                                        .setWeight(9)
                                        )
                        )
        );
    }
}