package net.dillon.speedrunnermod.loot.vanilla.container;

import net.dillon.speedrunnermod.component.ModPotions;
import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.Unit;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for end cities.
 */
public class EndCityLoot extends GeneratableLootTable {

    public EndCityLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        data.output().accept(
                BuiltInLootTables.END_CITY_TREASURE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                                        .apply(setCount(1, 4))
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.between(2, 6))
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(11)
                                                        .apply(SetPotionFunction.setPotion(Potions.LUCK))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.POTION)
                                                        .setWeight(10)
                                                        .apply(SetPotionFunction.setPotion(ModPotions.DRAGONS_AURA))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(15)
                                                        .apply(setCount(6, 18))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_BLOCK)
                                                        .setWeight(7)
                                                        .apply(setCount(3, 8))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(6)
                                                        .apply(setCount(3, 12))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD_BLOCK)
                                                        .setWeight(6)
                                                        .apply(setCount(3, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_BLOCK)
                                                        .setWeight(8)
                                                        .apply(setCount(3, 7))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SPEAR)
                                                        .setWeight(7)
                                                        .apply(enchantWithLevelsAndKey(EnchantmentTags.ON_RANDOM_LOOT, 40))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_SPEAR)
                                                        .setWeight(10)
                                                        .apply(enchantWithLevelsAndKey(EnchantmentTags.ON_RANDOM_LOOT, 40))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_AXE)
                                                        .setWeight(10)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                                        .setWeight(11)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_BOOTS)
                                                        .setWeight(9)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE)
                                                        .setWeight(10)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_LEGGINGS)
                                                        .setWeight(9)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_HELMET)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                                        .setWeight(8)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))

                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND_SHOVEL)
                                                        .setWeight(5)
                                                        .apply(enchantWithRandomSpeedrunnerLoot(40))

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
                                                LootItem.lootTableItem(ModItems.DRAGONS_PEARL)
                                                        .setWeight(8)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.KNOCKBACK_STICK)
                                                        .setWeight(5)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                                        .setWeight(7)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.ELYTRA)
                                                        .setWeight(1)
                                                        .apply(SetComponentsFunction.setComponent(DataComponents.ITEM_NAME, Component.translatable("item.speedrunnermod.icarus_wings")))
                                                        .apply(SetComponentsFunction.setComponent(DataComponents.UNBREAKABLE, Unit.INSTANCE))
                                        )
                        )
        );
    }
}