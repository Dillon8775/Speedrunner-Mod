package net.dillon.speedrunnermod.data;

import com.google.gson.JsonObject;
import net.dillon.speedrunnermod.option.ModCommonOptions;

import java.util.List;

import static net.dillon.speedrunnermod.option.ModCommonOptions.isDoomMode;

/**
 * Contains all of the {@code nether biomes modifications.}
 */
public record NetherBiomesLoader(EntitySpawnsLoader entitySpawnsLoader) {
    public static int MODIFIED_NETHER_BIOMES = 0;

    /**
     * Modifies the water color and monster spawns for the {@code basalt deltas} biome.
     */
    public void modifyBasaltDeltas() {
        JsonObject effects = entitySpawnsLoader().main().getEffectsObj();
        effects.addProperty("water_color", 0xCACFD2);
        effects.addProperty("water_fog_color", 0xD5DBDB);

        entitySpawnsLoader().modifyExistingMonsterSpawns(List.of(
                MobSpawnEntry.ofMonster(
                        "minecraft:ghast",
                        ModCommonOptions.doomOrDefault(50, 25),
                        1,
                        1
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:magma_cube",
                        ModCommonOptions.doomOrDefault(50, 25),
                        1,
                        4
                )
        ));

        if (isDoomMode()) {
            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:piglin_brute",
                    25,
                    1,
                    4
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:wither_skeleton",
                    50,
                    1,
                    4
            ));
        }

        MODIFIED_NETHER_BIOMES++;
    }

    /**
     * Modifies the water color and monster spawns for the {@code crimson forest} biome.
     */
    public void modifyCrimsonForest() {
        JsonObject effects = entitySpawnsLoader().main().getEffectsObj();
        effects.addProperty("water_color", 0xCD6155);
        effects.addProperty("water_fog_color", 0xE6B0AA);

        entitySpawnsLoader().modifyExistingMonsterSpawns(List.of(
                MobSpawnEntry.ofMonster(
                       "minecraft:zombified_piglin",
                       2,
                       1,
                       1
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:hoglin",
                        ModCommonOptions.doomOrDefault(50, 6),
                        ModCommonOptions.doomOrDefault(4, 1),
                        ModCommonOptions.doomOrDefault(6, 4)
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:piglin",
                        ModCommonOptions.doomOrDefault(25, 9),
                        2,
                        ModCommonOptions.doomOrDefault(6, 4)
                )
        ));

        if (isDoomMode()) {
            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:piglin_brute",
                    25,
                    1,
                    4
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:wither_skeleton",
                    50,
                    1,
                    4
            ));
        }

        MODIFIED_NETHER_BIOMES++;
    }

    /**
     * Modifies the water color and monster spawns for the {@code nether wastes} biome.
     */
    public void modifyNetherWastes() {
        JsonObject effects = entitySpawnsLoader().main().getEffectsObj();
        effects.addProperty("water_color", 0xD98880);
        effects.addProperty("water_fog_color", 0xE6B0AA);

        entitySpawnsLoader().modifyExistingMonsterSpawns(List.of(
                MobSpawnEntry.ofMonster(
                        "minecraft:ghast",
                        20,
                        1,
                        ModCommonOptions.doomOrDefault(1, 4)
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:zombified_piglin",
                        ModCommonOptions.doomOrDefault(50, 25),
                        ModCommonOptions.doomOrDefault(4, 1),
                        4
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:magma_cube",
                        ModCommonOptions.doomOrDefault(20, 1),
                        4,
                        4
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:enderman",
                        ModCommonOptions.doomOrDefault(20, 1),
                        4,
                        4
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:piglin",
                        ModCommonOptions.doomOrDefault(25, 50),
                        ModCommonOptions.doomOrDefault(1, 2),
                        ModCommonOptions.doomOrDefault(2, 4)
                )
        ));

        if (isDoomMode()) {
            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:piglin_brute",
                    25,
                    1,
                    4
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:hoglin",
                    100,
                    1,
                    4
            ));
        }

        MODIFIED_NETHER_BIOMES++;
    }

    /**
     * Modifies the water color and monster spawns for the {@code soul sand valley} biome.
     */
    public void modifySoulSandValley() {
        JsonObject effects = entitySpawnsLoader().main().getEffectsObj();
        effects.addProperty("water_color", 0xD98880);
        effects.addProperty("water_fog_color", 0xE6B0AA);

        entitySpawnsLoader().modifyExistingMonsterSpawns(List.of(
                MobSpawnEntry.ofMonster(
                        "minecraft:skeleton",
                        ModCommonOptions.doomOrDefault(50, 10),
                        ModCommonOptions.doomOrDefault(5, 1),
                        ModCommonOptions.doomOrDefault(5, 4)
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:ghast",
                        50,
                        ModCommonOptions.doomOrDefault(4, 1),
                        4
                ),
                MobSpawnEntry.ofMonster(
                        "minecraft:enderman",
                        ModCommonOptions.doomOrDefault(10, 5),
                        4,
                        4
                )
        ));

        if (isDoomMode()) {
            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:piglin_brute",
                    25,
                    1,
                    4
            ));
        }

        MODIFIED_NETHER_BIOMES++;
    }

    /**
     * Modifies the water color and monster spawns for the {@code warped forest} biome.
     */
    public void modifyWarpedForest() {
        JsonObject effects = entitySpawnsLoader().main().getEffectsObj();
        effects.addProperty("water_color", 0x167E86);
        effects.addProperty("water_fog_color", 0x14B485);

        entitySpawnsLoader().modifyExistingMonsterSpawns(List.of(
                MobSpawnEntry.ofMonster(
                        "minecraft:enderman",
                        5,
                        4,
                        4
                )
        ));

        entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                "minecraft:piglin",
                ModCommonOptions.doomOrDefault(25, 5),
                ModCommonOptions.doomOrDefault(4, 1),
                4
        ));

        if (isDoomMode()) {
            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:hoglin",
                    50,
                    1,
                    4
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:piglin_brute",
                    25,
                    1,
                    4
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:magma_cube",
                    50,
                    1,
                    4
            ));
        }

        MODIFIED_NETHER_BIOMES++;
    }
}