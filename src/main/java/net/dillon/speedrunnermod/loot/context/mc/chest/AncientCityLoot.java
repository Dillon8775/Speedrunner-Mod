package net.dillon.speedrunnermod.loot.context.mc.chest;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.context.mc.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.context.mc.LootTableData;
import net.dillon.speedrunnermod.tag.ModEnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for ancient cities.
 */
public class AncientCityLoot extends GeneratableLootTable {

    public AncientCityLoot(LootTableData data) {
        super(data);
    }

    /**
     * @see BuiltInLootTables#ANCIENT_CITY
     */
    @Override
    public void generateLoot() {
        data.context().accept(
                BuiltInLootTables.ANCIENT_CITY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE)
                                                        .setWeight(4)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(6)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BLOCK)
                                                        .setWeight(4)
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(5, 10))
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
                                                        .setWeight(15)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(5, 15)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(14)
                                                        .apply(new EnchantRandomlyFunction.Builder()
                                                                .withEnchantment(
                                                                        data.enchantments().getOrThrow(Enchantments.SWIFT_SNEAK)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(14)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(33))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(13)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                                        .setWeight(14)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(35))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(13)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(35))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(11)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(35))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
                                                        .setWeight(11)
                                                        .apply(EnchantWithLevelsFunction.enchantWithLevels(data.enchantments(), ContextIntProviders.exactly(35))
                                                                .withOptions(
                                                                        data.enchantments().getOrThrow(ModEnchantmentTags.ON_RANDOM_SPEEDRUNNER_LOOT)
                                                                )
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(7)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNERS_EYE)
                                                        .setWeight(11)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(10)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(9)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DISC_FRAGMENT_5)
                                                        .setWeight(8)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 7)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 12)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 14)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SCULK)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(4, 10)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(7)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(5)
                                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNERS_TOTEM)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(3)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MUSIC_DISC_OTHERSIDE)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR)
                                                        .setWeight(6)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_INGOT)
                                                        .setWeight(4)
                                        )
                        )
        );
        generateIceBoxLoot();
    }

    /**
     * @see BuiltInLootTables#ANCIENT_CITY_ICE_BOX
     */
    private void generateIceBoxLoot() {
        data.context().accept(
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                        )
        );
    }
}