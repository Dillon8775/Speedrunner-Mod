package net.dillon.speedrunnermod.loot.mc.chest;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.tag.ModEnchantmentTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.function.BiConsumer;

/**
 * Stores the loot table for ruined portals.
 */
public class RuinedPortalLoot {

    public static void generateLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context, HolderGetter<Enchantment> enchantments) {
        context.accept(
                BuiltInLootTables.RUINED_PORTAL,
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
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 8)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_AXE)
                                                        .apply(
                                                                EnchantWithLevelsFunction.enchantWithLevels(enchantments, ContextIntProviders.exactly(33))
                                                        )
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_PICKAXE)
                                                        .apply(
                                                                EnchantWithLevelsFunction.enchantWithLevels(enchantments, ContextIntProviders.exactly(33))
                                                        )
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_SWORD)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(enchantments)
                                                                .withOptions(
                                                                        enchantments.getOrThrow(ModEnchantmentTags.ON_GOLDEN_SWORD)
                                                                )
                                                        )
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(4, 8))
                                        .add(
                                                LootItem.lootTableItem(Items.ENDER_PEARL)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(21)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(7, 15)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GLOWSTONE)
                                                        .setWeight(1)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 18)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NUGGET)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 18)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FIRE_CHARGE)
                                                        .setWeight(18)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_NUGGET)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 18)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(20)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 27)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(25)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(9)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                        .setWeight(25)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_HOE)
                                                        .setWeight(2)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(enchantments, ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        enchantments.getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_SHOVEL)
                                                        .setWeight(3)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(enchantments, ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        enchantments.getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_BOOTS)
                                                        .setWeight(3)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(enchantments, ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        enchantments.getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_HELMET)
                                                        .setWeight(3)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(enchantments, ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        enchantments.getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_LEGGINGS)
                                                        .setWeight(3)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(enchantments, ContextIntProviders.exactly(30))
                                                                .withOptions(
                                                                        enchantments.getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                        )
        );
    }
}