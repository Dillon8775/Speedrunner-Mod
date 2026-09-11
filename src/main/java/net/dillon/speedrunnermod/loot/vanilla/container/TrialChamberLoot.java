package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.component.ModEnchantments;
import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.dillon.speedrunnermod.tag.ModEnchantmentTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetEnchantmentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetOminousBottleAmplifierFunction;
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
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_AXE)
                                                        .setWeight(6)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(26))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_PICKAXE)
                                                        .setWeight(6)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(5)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(24))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_PEARL)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(4)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_ORE)
                                                        .setWeight(4)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_PLANKS)
                                                        .setWeight(5)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(8)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 12))
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
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(8)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 8))
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
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FIRE_CHARGE)
                                                        .setWeight(7)
                                                        .apply(setCount(4, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SNOWBALL)
                                                        .setWeight(3)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EGG)
                                                        .setWeight(2)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WATER_BUCKET)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.SLOWNESS))
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.POISON))
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPLASH_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.WEAKNESS))
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.SLOWNESS))
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.POISON))
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.WEAKNESS))
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.HEALING))
                                                        .apply(setCount(2, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION))
                                                        .apply(setCount(2, 3))
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
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(10)
                                                        .apply(setCount(9, 36))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(8)
                                                        .apply(setCount(6, 21))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(7)
                                                        .apply(setCount(4, 8))
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
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(12)
                                                        .apply(setCount(4, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(8)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BLOCK)
                                                        .setWeight(7)
                                                        .apply(setCount(2, 5))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.AMETHYST_SHARD)
                                                        .setWeight(4)
                                                        .apply(setCount(13, 49))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD_BLOCK)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 11))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_AXE)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                                        .setWeight(7)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))
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
                                                        .apply(setCount(4, 16))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(10)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(10)
                                                        .apply(setCount(8, 26))
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
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(7)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BOOTS)
                                                        .setWeight(9)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(30))
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
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(6)
                                                        .apply(setCount(6, 36))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TIPPED_ARROW)
                                                        .setWeight(6)
                                                        .apply(setCount(10, 26))
                                                        .apply(SetPotionFunction.setPotion(Potions.POISON))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WIND_CHARGE)
                                                        .setWeight(12)
                                                        .apply(setCount(8, 24))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(6)
                                                        .apply(setCount(6, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(12)
                                                        .apply(setCount(6, 15))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(8)
                                                        .apply(setCount(16, 32))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OMINOUS_BOTTLE)
                                                        .setWeight(9)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(4)
                                        )
                        )
        );
    }

    private void generateRewardOminousCommonLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.ANNUL_EYE)
                                                        .setWeight(8)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(8)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(12)
                                                        .apply(setCount(4, 21))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WIND_CHARGE)
                                                        .setWeight(10)
                                                        .apply(setCount(12, 24))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TIPPED_ARROW)
                                                        .setWeight(6)
                                                        .apply(setCount(9, 32))
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_HARMING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OMINOUS_BOTTLE)
                                                        .setWeight(7)
                                                        .apply(SetOminousBottleAmplifierFunction.setAmplifier(ContextIntProviders.between(3, 6)))
                                        )
                        )
        );
    }

    private void generateRewardOminousRareLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(9)
                                                        .apply(new SetEnchantmentsFunction.Builder()
                                                                .withEnchantment(
                                                                       data.enchantments().getOrThrow(Enchantments.WIND_BURST), ContextIntProviders.exactly(1)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(11)
                                                        .apply(enchantWithLevelsAndKey(ModEnchantmentTags.FROM_OMINOUS_CHAMBER_RARE, 35))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(13)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(27, 33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(10)
                                                        .apply(setCount(5, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BLOCK)
                                                        .setWeight(9)
                                                        .apply(setCount(3, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(8)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ANNUL_EYE)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD_BLOCK)
                                                        .setWeight(7)
                                                        .apply(setCount(5, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(3)
                                        )
                        )
        );
    }

    private void generateRewardOminousUniqueLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(9)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(11)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(9)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HEAVY_CORE)
                                                        .setWeight(10)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MUSIC_DISC_CREATOR)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                        )
                        )
        );
    }

    private void generateRewardRareLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(10)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(27, 33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SHIELD)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_AXE)
                                                        .setWeight(9)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOW)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CROSSBOW)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                        )
        );
    }

    private void generateRewardUniqueLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(10)
                                                        .apply(setCount(3, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                        .setWeight(8)
                                                        .apply(setCount(6, 19))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GUSTER_BANNER_PATTERN)
                                                        .setWeight(3)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TRIDENT)
                                                        .setWeight(6)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(26, 30))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MUSIC_DISC_PRECIPICE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(4)
                                        )
                        )
        );
    }

    private void generateSupplyLoot() {
        data.output().accept(
                BuiltInLootTables.TRIAL_CHAMBERS_SUPPLY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(11)
                                                        .apply(setCount(12, 36))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                                        .setWeight(8)
                                                        .apply(new SetEnchantmentsFunction.Builder()
                                                                .withEnchantment(
                                                                       data.enchantments().getOrThrow(ModEnchantments.DASH), ContextIntProviders.between(1, 3)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(9)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(9)
                                                        .apply(setCount(12, 36))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(8)
                                                        .apply(setCount(6, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNERS_EYE)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TIPPED_ARROW)
                                                        .setWeight(6)
                                                        .apply(setCount(12, 28))
                                                        .apply(SetPotionFunction.setPotion(Potions.POISON))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(6)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(6)
                                                        .apply(SetPotionFunction.setPotion(Potions.LONG_STRENGTH))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.TIPPED_ARROW)
                                                        .setWeight(6)
                                                        .apply(setCount(12, 28))
                                                        .apply(SetPotionFunction.setPotion(Potions.SLOWNESS))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.THRUSTED_BLOCK)
                                                        .setWeight(4)
                                                        .apply(setCount(24, 36))
                                        )
                        )
        );
    }

    private void generateSpawnerConsumables() {
        data.output().accept(
                BuiltInLootTables.SPAWNER_TRIAL_CHAMBER_CONSUMABLES,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(8)
                                                        .apply(setCount(4, 16))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(6)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(5)
                                                        .apply(randomEnchantment(EnchantmentTags.ON_RANDOM_LOOT))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(4)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_STRENGTH))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(4)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_SWIFTNESS))
                                        )
                        )
        );
    }

    private void generateSpawnerOminousConsumables() {
        data.output().accept(
                BuiltInLootTables.SPAWNER_OMINOUS_TRIAL_CHAMBER_CONSUMABLES,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(8)
                                                        .apply(setCount(4, 9))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(6)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(7)
                                                        .apply(setCount(5, 21))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(8)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(8)
                                                        .apply(enchantWithLevelsAndKey(EnchantmentTags.ON_RANDOM_LOOT, 27))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(4)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_STRENGTH))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(4)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_SWIFTNESS))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ANNUL_EYE)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.RAID_ERADICATOR)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(2)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.KNOCKBACK_STICK)
                                                        .setWeight(1)
                                        )
                        )
        );
    }

    private void generateItemsToDropWhenOminous() {
        data.output().accept(
                BuiltInLootTables.SPAWNER_TRIAL_ITEMS_TO_DROP_WHEN_OMINOUS,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_STRENGTH))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_SWIFTNESS))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.REGENERATION))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.INVISIBILITY))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.WIND_CHARGED))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.OOZING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.WEAVING))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LINGERING_POTION)
                                                        .apply(SetPotionFunction.setPotion(Potions.INFESTED))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.FIRE_CHARGE)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WIND_CHARGE)
                                                        .apply(setCount(8, 16))
                                        )
                        )
        );
    }
}