package net.dillon.speedrunnermod.entity;

import net.dillon.dillonlib.factory.Factories;
import net.dillon.speedrunnermod.item.core.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;

/**
 * All different entity types for the speedrunner mod.
 */
public class ModEntityTypes {
    public static final EntityType<Boat> SPEEDRUNNER_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.SPEEDRUNNER_BOAT.identifier(),
            () -> ModItems.SPEEDRUNNER_BOAT,
            false
    );

    public static final EntityType<ChestBoat> SPEEDRUNNER_CHEST_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.SPEEDRUNNER_CHEST_BOAT.identifier(),
            () -> ModItems.SPEEDRUNNER_CHEST_BOAT,
            true
    );

    public static final EntityType<Boat> DEAD_SPEEDRUNNER_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.DEAD_SPEEDRUNNER_BOAT.identifier(),
            () -> ModItems.DEAD_SPEEDRUNNER_BOAT,
            false
    );

    public static final EntityType<ChestBoat> DEAD_SPEEDRUNNER_CHEST_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.DEAD_SPEEDRUNNER_CHEST_BOAT.identifier(),
            () -> ModItems.DEAD_SPEEDRUNNER_CHEST_BOAT,
            true
    );

    public static final EntityType<Boat> CRIMSON_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.CRIMSON_BOAT.identifier(),
            () -> ModItems.CRIMSON_BOAT,
            false
    );

    public static final EntityType<ChestBoat> CRIMSON_CHEST_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.CRIMSON_CHEST_BOAT.identifier(),
            () -> ModItems.CRIMSON_CHEST_BOAT,
            true
    );

    public static final EntityType<Boat> WARPED_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.WARPED_BOAT.identifier(),
            () -> ModItems.WARPED_BOAT,
            false
    );

    public static final EntityType<ChestBoat> WARPED_CHEST_BOAT = Factories.registerBoatFactory(
            ModEntityTypeIds.WARPED_CHEST_BOAT.identifier(),
            () -> ModItems.WARPED_CHEST_BOAT,
            true
    );

    /**
     * Initializes all {@code Speedrunner Mod entity types.}
     */
    public static void initializeEntityTypes() {
    }
}