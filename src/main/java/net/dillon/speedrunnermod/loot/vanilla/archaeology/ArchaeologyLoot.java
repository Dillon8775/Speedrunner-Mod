package net.dillon.speedrunnermod.loot.vanilla.archaeology;

import net.dillon.speedrunnermod.item.core.ModItems;
import net.dillon.speedrunnermod.loot.data.GeneratableLootTable;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetStewEffectFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

/**
 * Stores the loot tables for archaeology.
 */
public class ArchaeologyLoot extends GeneratableLootTable {

    public ArchaeologyLoot(LootTableData data) {
        super(data);
    }

    @Override
    public void generateLoot() {
        generateDesertWellLoot();
        generateDesertPyramidLoot();
        generateTrailRuinsCommonLoot();
        generateTrailRuinsRareLoot();
        generateOceanRuinWarmLoot();
        generateOceanRuinColdLoot();
    }

    private void generateDesertWellLoot() {
        data.output().accept(
                BuiltInLootTables.DESERT_WELL_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.ARMS_UP_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.BREWER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.COOKED_FLESH)
                                                        .apply(setCount(1, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SUSPICIOUS_STEW)
                                                        .apply(
                                                                SetStewEffectFunction.stewEffect()
                                                                        .withEffect(MobEffects.NIGHT_VISION, ContextIntProviders.between(7, 10))
                                                                        .withEffect(MobEffects.JUMP_BOOST, ContextIntProviders.between(7, 10))
                                                                        .withEffect(MobEffects.SATURATION, ContextIntProviders.between(10, 20))
                                                                        .withEffect(MobEffects.REGENERATION, ContextIntProviders.between(15, 20))
                                                        )
                                        )

                        )
        );
    }

    private void generateDesertPyramidLoot() {
        data.output().accept(
                BuiltInLootTables.DESERT_PYRAMID_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.ARCHER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MINER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PRIZE_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SKULL_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.COOKED_FLESH)
                                                        .apply(setCount(1, 6))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_LOG)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GUNPOWDER)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .apply(setCount(1, 3))
                                        )
                        )
        );
    }

    private void generateTrailRuinsCommonLoot() {
        data.output().accept(
                BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                                        .apply(setCount(1, 2))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNERS_EYE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STONE_SPEAR)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.COAL)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.STRING)
                                        )
                        )
        );
    }

    private void generateTrailRuinsRareLoot() {
        data.output().accept(
                BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BURN_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DANGER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.FRIEND_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HEART_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HEARTBREAK_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HOWL_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SHEAF_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MUSIC_DISC_RELIC)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNERS_EYE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ANNUL_EYE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.DRAGON_FIREBALL)
                                        )
                        )
        );
    }

    private void generateOceanRuinWarmLoot() {
        data.output().accept(
                BuiltInLootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ContextIntProviders.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(Items.BLADE_POTTERY_SHERD))
                                        .add(
                                                LootItem.lootTableItem(Items.EXPLORER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MOURNER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PLENTY_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(2)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.SNIFFER_EGG)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 2))
                                        )
                        )
        );
    }

    private void generateOceanRuinColdLoot() {
        data.output().accept(
                BuiltInLootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .add(
                                                LootItem.lootTableItem(Items.BLADE_POTTERY_SHERD))
                                        .add(
                                                LootItem.lootTableItem(Items.EXPLORER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.MOURNER_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.PLENTY_POTTERY_SHERD)
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.EMERALD)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 3))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.IRON_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.DIAMOND)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.SPEEDRUNNER_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(Items.GOLD_INGOT)
                                                        .setWeight(2)
                                                        .apply(setCount(1, 4))
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.EXPERIENCE_FRAGMENT)
                                                        .setWeight(2)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_THRUSTER)
                                        )
                                        .add(
                                                LootItem.lootTableItem(ModItems.ENDER_MATTER)
                                        )
                        )
        );
    }
}