package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.functions.SetStewEffectFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for ancient cities.
 */
public class AncientCityLoot extends GeneratableLootTable {

    public AncientCityLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
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
                                                        .apply(setCount(3, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(7)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(5)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(9)
                                                        .apply(setCount(2, 3))
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
                                                        .apply(setCount(5, 15))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(14)
                                                        .apply(withEnchantment(Enchantments.SWIFT_SNEAK))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BOOK)
                                                        .setWeight(14)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(33))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(13)
                                                        .apply(setCount(2, 5))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BOOTS)
                                                        .setWeight(14)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(35))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_CHESTPLATE)
                                                        .setWeight(13)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(35))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(11)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(35))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
                                                        .setWeight(11)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(35))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(7)
                                                        .apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNERS_EYE)
                                                        .setWeight(11)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BULK)
                                                        .setWeight(10)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                        .setWeight(9)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DISC_FRAGMENT_5)
                                                        .setWeight(8)
                                                        .apply(setCount(2, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(7)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 14))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SCULK)
                                                        .setWeight(7)
                                                        .apply(setCount(4, 10))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(7)
                                                        .apply(setCount(2, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(5)
                                                        .apply(setCount(1, 2))
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

    private void generateIceBoxLoot() {
        data.output().accept(
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(4, 10))
                                        .add(
                                                LootItem.lootTableItem(Items.SUSPICIOUS_STEW)
                                                        .setWeight(8)
                                                        .apply(
                                                                SetStewEffectFunction.stewEffect()
                                                                        .withEffect(MobEffects.NIGHT_VISION, ContextIntProviders.between(8, 20))
                                                                        .withEffect(MobEffects.JUMP_BOOST, ContextIntProviders.between(7, 10))
                                                                        .withEffect(MobEffects.SATURATION, ContextIntProviders.between(10, 15))
                                                                        .withEffect(MobEffects.REGENERATION, ContextIntProviders.between(10, 20))
                                                        )
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                                        .setWeight(10)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(8)
                                                        .apply(setCount(1, 5))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(9)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SNOWBALL)
                                                        .setWeight(6)
                                                        .apply(setCount(4, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .setWeight(4)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.INVENTORY_PRESERVER)
                                                        .setWeight(2)
                                        )
                        )
        );
    }
}