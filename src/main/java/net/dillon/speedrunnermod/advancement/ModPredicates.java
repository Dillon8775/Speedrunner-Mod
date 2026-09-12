package net.dillon.speedrunnermod.advancement;

import net.minecraft.advancements.triggers.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

/**
 * All speedrunner mod predicate.
 */
public class ModPredicates {
    public static final ItemLikeTrigger TRIGGERED_BY_ITEMLIKE = register("itemlike_trigger", new ItemLikeTrigger());

    /**
     * Registers a mod predicate.
     */
    private static <T extends CriterionTrigger<?>> T register(String id, T criterion) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, id, criterion);
    }

    /**
     * Initializes speedrunner mod predicates.
     */
    public static void initializePredicates() {
    }
}