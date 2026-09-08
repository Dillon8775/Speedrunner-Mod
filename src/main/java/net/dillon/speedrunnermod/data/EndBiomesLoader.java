package net.dillon.speedrunnermod.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import static net.dillon.speedrunnermod.option.ModCommonOptions.doomOrDefault;
import static net.dillon.speedrunnermod.option.ModCommonOptions.isDoomMode;

/**
 * Contains all of the {@code end biome modifications.}
 */
public record EndBiomesLoader(EntitySpawnsLoader entitySpawnsLoader) {
    public static int MODIFIED_END_BIOMES = 0;

    /**
     * Modifies the end biome and it's entity spawns.
     */
    public void modifyTheEnd() {
        entitySpawnsLoader().modifyExistingMonsterSpawns(List.of(
                MobSpawnEntry.ofMonster(
                        "minecraft:enderman",
                        doomOrDefault(85, 10),
                        1,
                        4
                )
        ));

        if (isDoomMode()) {
            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:skeleton",
                    70,
                    1,
                    4
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:vindicator",
                    60,
                    1,
                    2
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:zombie",
                    50,
                    1,
                    1
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:ravager",
                    40,
                    1,
                    1
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:phantom",
                    40,
                    1,
                    1
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:evoker",
                    25,
                    1,
                    1
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:breeze",
                    25,
                    1,
                    1
            ));

            entitySpawnsLoader().addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:witch",
                    5,
                    1,
                    1
            ));

            // Add ambient particles as an object
            JsonObject attributes = entitySpawnsLoader().main().getAttributesObj();

            JsonObject ambientParticles = new JsonObject();
            attributes.add("minecraft:visual/ambient_particles", ambientParticles);

            // Create the argument array
            JsonArray argument = new JsonArray();

            // Create the crimson spore particle object
            JsonObject particleEntry = new JsonObject();
            JsonObject particle = new JsonObject();

            particle.addProperty("type", "minecraft:crimson_spore");

            particleEntry.add("particle", particle);
            particleEntry.addProperty("probability", 0.050D);

            // Add the particle only in Doom Mode
            argument.add(particleEntry);
            ambientParticles.add("argument", argument);
            ambientParticles.addProperty("modifier", "append");
        }

        MODIFIED_END_BIOMES++;
    }

    /**
     * Modifies the {@code end noise settings}.
     */
    public void modifyEnd() {
        JsonObject root = entitySpawnsLoader().main().rootJsonElement().getAsJsonObject();
        root.addProperty("default_block", isDoomMode() ? "speedrunnermod:doom_stone" : "minecraft:end_stone");
        root.addProperty("material_rule", isDoomMode() ? "speedrunnermod:end_doom" : "minecraft:end");
        MODIFIED_END_BIOMES++;
    }
}