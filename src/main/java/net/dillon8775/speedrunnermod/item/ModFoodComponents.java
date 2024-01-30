package net.dillon8775.speedrunnermod.item;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    protected static final FoodComponent SPEEDRUNNER_BULK;
    protected static final FoodComponent ROTTEN_SPEEDRUNNER_BULK;
    protected static final FoodComponent COOKED_FLESH;
    protected static final FoodComponent PIGLIN_PORK;
    protected static final FoodComponent COOKED_PIGLIN_PORK;
    protected static final FoodComponent GOLDEN_PIGLIN_PORK;
    protected static final FoodComponent GOLDEN_BEEF;
    protected static final FoodComponent GOLDEN_PORKCHOP;
    protected static final FoodComponent GOLDEN_MUTTON;
    protected static final FoodComponent GOLDEN_CHICKEN;
    protected static final FoodComponent GOLDEN_RABBIT;
    protected static final FoodComponent GOLDEN_COD;
    protected static final FoodComponent GOLDEN_SALMON;
    protected static final FoodComponent GOLDEN_BREAD;
    protected static final FoodComponent GOLDEN_POTATO;
    protected static final FoodComponent GOLDEN_BEETROOT;
    public static final FoodComponent APPLE;
    public static final FoodComponent BAKED_POTATO;
    public static final FoodComponent BEEF;
    public static final FoodComponent BEETROOT;
    public static final FoodComponent BREAD;
    public static final FoodComponent CARROT;
    public static final FoodComponent CHICKEN;
    public static final FoodComponent CHORUS_FRUIT;
    public static final FoodComponent COD;
    public static final FoodComponent COOKED_BEEF;
    public static final FoodComponent COOKED_CHICKEN;
    public static final FoodComponent COOKED_COD;
    public static final FoodComponent COOKED_MUTTON;
    public static final FoodComponent COOKED_PORKCHOP;
    public static final FoodComponent COOKED_RABBIT;
    public static final FoodComponent COOKED_SALMON;
    public static final FoodComponent COOKIE;
    public static final FoodComponent DRIED_KELP;
    public static final FoodComponent ENCHANTED_GOLDEN_APPLE;
    public static final FoodComponent GOLDEN_APPLE;
    public static final FoodComponent GOLDEN_CARROT;
    public static final FoodComponent HONEY_BOTTLE;
    public static final FoodComponent MELON_SLICE;
    public static final FoodComponent MUTTON;
    public static final FoodComponent POISONOUS_POTATO;
    public static final FoodComponent PORKCHOP;
    public static final FoodComponent POTATO;
    public static final FoodComponent PUFFERFISH;
    public static final FoodComponent PUMPKIN_PIE;
    public static final FoodComponent RABBIT;
    public static final FoodComponent ROTTEN_FLESH;
    public static final FoodComponent SALMON;
    public static final FoodComponent SPIDER_EYE;
    public static final FoodComponent SWEET_BERRIES;
    public static final FoodComponent GLOW_BERRIES;
    public static final FoodComponent TROPICAL_FISH;

    static {
        SPEEDRUNNER_BULK = new FoodComponent.Builder().hunger(12).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 500, 1), 0.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.25F).alwaysEdible().build();
        ROTTEN_SPEEDRUNNER_BULK = new FoodComponent.Builder().hunger(4).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 400, 0), 0.5F).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 0), 0.1F).meat().build();
        COOKED_FLESH = new FoodComponent.Builder().hunger(6).saturationModifier(0.8F).build();
        PIGLIN_PORK = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build() : new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build();
        COOKED_PIGLIN_PORK = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build() : new FoodComponent.Builder().hunger(8).saturationModifier(0.7F).build();
        GOLDEN_PIGLIN_PORK = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).build() : new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build();
        GOLDEN_BEEF = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(8).saturationModifier(1.0F).meat().build() : new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).meat().build();
        GOLDEN_PORKCHOP = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(8).saturationModifier(1.0F).meat().build() : new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).meat().build();
        GOLDEN_MUTTON = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(6).saturationModifier(1.0F).meat().build() : new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).meat().build();
        GOLDEN_CHICKEN = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(6).saturationModifier(1.0F).meat().build() : new FoodComponent.Builder().hunger(8).saturationModifier(0.7F).meat().build();
        GOLDEN_RABBIT = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(5).saturationModifier(1.2F).meat().build() : new FoodComponent.Builder().hunger(5).saturationModifier(0.7F).meat().build();
        GOLDEN_COD = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(5).saturationModifier(1.2F).meat().build() : new FoodComponent.Builder().hunger(5).saturationModifier(0.7F).meat().build();
        GOLDEN_SALMON = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(6).saturationModifier(1.0F).meat().build() : new FoodComponent.Builder().hunger(6).saturationModifier(0.9F).meat().build();
        GOLDEN_BREAD = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(5).saturationModifier(1.2F).meat().build() : new FoodComponent.Builder().hunger(5).saturationModifier(0.7F).meat().build();
        GOLDEN_POTATO = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(6).saturationModifier(1.0F).meat().build() : new FoodComponent.Builder().hunger(5).saturationModifier(0.7F).meat().build();
        GOLDEN_BEETROOT = SpeedrunnerMod.options().advanced.betterFoods ? new FoodComponent.Builder().hunger(2).saturationModifier(1.5F).meat().build() : new FoodComponent.Builder().hunger(2).saturationModifier(0.7F).meat().build();
        APPLE = new FoodComponent.Builder().hunger(4).saturationModifier(0.8F).build();
        BAKED_POTATO = new FoodComponent.Builder().hunger(6).saturationModifier(0.9F).build();
        BEEF = new FoodComponent.Builder().hunger(4).saturationModifier(0.7F).meat().build();
        BEETROOT = new FoodComponent.Builder().hunger(2).saturationModifier(1.4F).build();
        BREAD = new FoodComponent.Builder().hunger(5).saturationModifier(1.1F).build();
        CARROT = new FoodComponent.Builder().hunger(3).saturationModifier(1.2F).build();
        CHICKEN = new FoodComponent.Builder().hunger(2).saturationModifier(1.2F).build();
        CHORUS_FRUIT = new FoodComponent.Builder().hunger(4).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F).alwaysEdible().build();
        COD = new FoodComponent.Builder().hunger(2).saturationModifier(1.2F).build();
        COOKED_BEEF = new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).meat().build();
        COOKED_CHICKEN = new FoodComponent.Builder().hunger(6).saturationModifier(0.9F).meat().build();
        COOKED_COD = new FoodComponent.Builder().hunger(5).saturationModifier(1.1F).build();
        COOKED_MUTTON = new FoodComponent.Builder().hunger(6).saturationModifier(0.9F).meat().build();
        COOKED_PORKCHOP = new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).meat().build();
        COOKED_RABBIT = new FoodComponent.Builder().hunger(5).saturationModifier(1.1F).meat().build();
        COOKED_SALMON = new FoodComponent.Builder().hunger(6).saturationModifier(0.9F).build();
        COOKIE = new FoodComponent.Builder().hunger(2).saturationModifier(1.3F).build();
        DRIED_KELP = new FoodComponent.Builder().hunger(1).saturationModifier(0.6F).snack().build();
        ENCHANTED_GOLDEN_APPLE = new FoodComponent.Builder().hunger(4).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0F).alwaysEdible().build();
        GOLDEN_APPLE = new FoodComponent.Builder().hunger(4).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEdible().build();
        GOLDEN_CARROT = new FoodComponent.Builder().hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0F).build();
        HONEY_BOTTLE = new FoodComponent.Builder().hunger(6).saturationModifier(0.5F).build();
        MELON_SLICE = new FoodComponent.Builder().hunger(4).saturationModifier(1.2F).build();
        MUTTON = new FoodComponent.Builder().hunger(2).saturationModifier(0.8F).meat().build();
        POISONOUS_POTATO = new FoodComponent.Builder().hunger(2).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 0.6F).build();
        PORKCHOP = new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).meat().build();
        POTATO = new FoodComponent.Builder().hunger(1).saturationModifier(1.0F).build();
        PUFFERFISH = new FoodComponent.Builder().hunger(1).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 3), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 2), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1.0F).build();
        PUMPKIN_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).build();
        RABBIT = new FoodComponent.Builder().hunger(3).saturationModifier(0.9F).meat().build();
        ROTTEN_FLESH = new FoodComponent.Builder().hunger(4).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 0), 0.8F).meat().build();
        SALMON = new FoodComponent.Builder().hunger(2).saturationModifier(1.4F).build();
        SPIDER_EYE = new FoodComponent.Builder().hunger(2).saturationModifier(1.1F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F).build();
        SWEET_BERRIES = new FoodComponent.Builder().hunger(4).saturationModifier(1.2F).build();
        GLOW_BERRIES = new FoodComponent.Builder().hunger(2).saturationModifier(1.0F).build();
        TROPICAL_FISH = new FoodComponent.Builder().hunger(2).saturationModifier(1.2F).build();
    }
}