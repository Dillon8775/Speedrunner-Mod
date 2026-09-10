package net.dillon.speedrunnermod.loot.vanilla.container;

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
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for trial chambers.
 */
public class TrialChamberLoot extends GeneratableLootTable {

    public TrialChamberLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateCorridorLoot();
        generateCorridorDispenserLoot();
        generateChamberDispenserLoot();
        generateEntranceLoot();
        generateIntersectionLoot();
        generateIntersectionBarrelLoot();
        generateRewardCommonLoot();
        generateRewardOminousCommonLoot();
        generateRewardOminousRareLoot();
        generateRewardOminousUniqueLoot();
        generateRewardRareLoot();
        generateRewardUniqueLoot();
        generateSupplyLoot();
        generateSpawnerConsumables();
        generateSpawnerOminousConsumables();
        generateItemsToDropWhenOminous();
    }

    private void generateCorridorLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_CORRIDOR,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 3))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_AXE)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_AXE)
                                                        .setWeight(6)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(26))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_PICKAXE)
                                                        .setWeight(6)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(5)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(24))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_PEARL)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_ORE)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PLANKS)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                        )
        );
    }

    private void generateCorridorDispenserLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_CORRIDOR_DISPENSER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(11))
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 8)))
                                        )
                        )
        );
    }

    private void generateChamberDispenserLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_CHAMBER_DISPENSER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FIRE_CHARGE)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SNOWBALL)
                                                        .setWeight(3)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EGG)
                                                        .setWeight(2)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WATER_BUCKET)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.SLOWNESS))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.POISON))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.WEAKNESS))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.SLOWNESS))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.POISON))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.WEAKNESS))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.HEALING))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION))
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                        )
        );
    }

    private void generateEntranceLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_ENTRANCE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.TRIAL_KEY)
                                                        .setWeight(25)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 21)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 8)))
                                        )
                        )
        );
    }

    private void generateIntersectionLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_INTERSECTION,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BLOCK)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BLOCK)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.AMETHYST_SHARD)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(13, 49)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD_BLOCK)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_AXE)
                                                        .setWeight(8)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                    data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                        )
        );
    }

    private void generateIntersectionBarrelLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_INTERSECTION_BARREL,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 3))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 16)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(8, 26)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_AXE)
                                                        .setWeight(12)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                                        .setWeight(10)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BOOTS)
                                                        .setWeight(9)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                        )
        );
    }

    private void generateRewardCommonLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_COMMON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateRewardOminousCommonLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateRewardOminousRareLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateRewardOminousUniqueLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateRewardRareLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateRewardUniqueLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateSupplyLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_SUPPLY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateSpawnerConsumables() {
        data.output().accept(
                BuiltInLootTables.SPAWNER_TRIAL_CHAMBER_CONSUMABLES,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateSpawnerOminousConsumables() {
        data.output().accept(
                BuiltInLootTables.SPAWNER_OMINOUS_TRIAL_CHAMBER_CONSUMABLES,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }

    private void generateItemsToDropWhenOminous() {
        data.output().accept(
                BuiltInLootTables.SPAWNER_TRIAL_ITEMS_TO_DROP_WHEN_OMINOUS,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}