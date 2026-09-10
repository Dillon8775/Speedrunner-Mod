package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.dillon.speedrunnermod.tag.ModEnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for bastions.
 */
public class BastionLoot extends GeneratableLootTable {

    public BastionLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateBridgeLoot();
        generateHoglinStableLoot();
        generateOtherLoot();
        generateTreasureLoot();
    }

    private void generateBridgeLoot() {
        data.output().accept(
                BuiltInLootTables.BASTION_BRIDGE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 2))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(9)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments())
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_BOOK)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CROSSBOW)
                                                        .setWeight(6)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.5F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CROSSBOW)
                                                        .setWeight(5)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.5F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_SWORD)
                                                        .setWeight(9)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                     data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_HELMET)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CHESTPLATE)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_LEGGINGS)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_BOOTS)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_AXE)
                                                        .setWeight(9)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(18)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                        .setWeight(17)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(16)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(10, 34)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CRYING_OBSIDIAN)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 8)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(11)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.RESPAWN_ANCHOR)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GILDED_BLACKSTONE)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 9)))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 4))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 27)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NUGGET)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 47)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_NUGGET)
                                                        .setWeight(18)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(7, 27)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.RESPAWN_ANCHOR)
                                                        .setWeight(5)
                                        )
                        )
        );
    }

    private void generateHoglinStableLoot() {
        data.output().accept(
                BuiltInLootTables.BASTION_HOGLIN_STABLE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
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
                                                LootItem.lootTableItem(Items.DIAMOND_SHOVEL)
                                                        .setWeight(9)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.15F, 0.8F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                                        .setWeight(12)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.15F, 0.95F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                        .setWeight(18)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(13)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(8, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ANCIENT_DEBRIS)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ANCIENT_DEBRIS)
                                                        .setWeight(12)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_SCRAP)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SADDLE)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.RESPAWN_ANCHOR)
                                                        .setWeight(5)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 4))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(7)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments())
                                                                .withOptions(
                                                                       data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_BOOK)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_AXE)
                                                        .setWeight(6)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                      data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(17)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_NUGGET)
                                                        .setWeight(16)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 45)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.PIGLIN_PORK)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 18)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.COOKED_PIGLIN_PORK)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 27)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CRYING_OBSIDIAN)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GLOWSTONE)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GILDED_BLACKSTONE)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.LEATHER)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SOUL_SAND)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.RESPAWN_ANCHOR)
                                                        .setWeight(5)
                                        )
                        )
        );
    }

    private void generateOtherLoot() {
        data.output().accept(
                BuiltInLootTables.BASTION_OTHER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
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
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CROSSBOW)
                                                        .setWeight(7)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.5F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                      data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                                        .setWeight(12)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SHOVEL)
                                                        .setWeight(7)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CROSSBOW)
                                                        .setWeight(6)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.9F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(12)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(12, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(13)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_SCRAP)
                                                        .setWeight(12)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ANCIENT_DEBRIS)
                                                        .setWeight(10)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PIGLIN_BANNER_PATTERN)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MUSIC_DISC_PIGSTEP)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.RESPAWN_ANCHOR)
                                                        .setWeight(4)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(2))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(8)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments())
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_BOOK)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_SWORD)
                                                        .setWeight(10)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.1F, 0.9F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_SWORD)
                                                        .setWeight(9)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_AXE)
                                                        .setWeight(5)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_HELMET)
                                                        .setWeight(4)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CHESTPLATE)
                                                        .setWeight(4)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_LEGGINGS)
                                                        .setWeight(4)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_BOOTS)
                                                        .setWeight(5)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 24)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 9)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(14)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CRYING_OBSIDIAN)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BLOCK)
                                                        .setWeight(15)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(14)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CROSSBOW)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.CROSSBOW)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(4)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 4))
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_NUGGET)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 24)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_NUGGET)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ARROW)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 24)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 27)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.COOKED_PIGLIN_PORK)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(7, 27)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GILDED_BLACKSTONE)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_CHAIN)
                                                        .setWeight(3)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 10)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MAGMA_CREAM)
                                                        .setWeight(3)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BONE_BLOCK)
                                                        .setWeight(3)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 6)))
                                        )
                        )
        );
    }

    private void generateTreasureLoot() {
        data.output().accept(
                BuiltInLootTables.BASTION_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(1, 2))
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(9)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(1)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(4))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(7)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments())
                                                                .withOptions(
                                                                       data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_BOOK)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(13)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.8F, 1.0F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HELMET)
                                                        .setWeight(8)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.8F, 1.0F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE)
                                                        .setWeight(8)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.8F, 1.0F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
                                                        .setWeight(8)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.8F, 1.0F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BOOTS)
                                                        .setWeight(8)
                                                        .apply(SetItemDamageFunction.setDamage(ContextFloatProviders.between(0.8F, 1.0F)))
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_INGOT)
                                                        .setWeight(17)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ANCIENT_DEBRIS)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ANCIENT_DEBRIS)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_SCRAP)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(10)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_SPEEDRUNNER_SPEAR)
                                                        .setWeight(9)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_SPEAR)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HELMET)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BOOTS)
                                                        .setWeight(3)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(3, 5))
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(10)
                                                        .apply(EnchantRandomlyFunction.randomApplicableEnchantment(data.enchantments())
                                                                .withOptions(
                                                                     data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_BOOK)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BLOCK)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SPECTRAL_ARROW)
                                                        .setWeight(12)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(12, 36)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 21)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 27)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_NUGGET)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(9, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.OBSIDIAN)
                                                        .setWeight(4)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(6, 11)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(8)
                                        )
                        )
        );
    }
}