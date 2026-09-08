package net.dillon.speedrunnermod.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.dillon.speedrunnermod.option.ModCommonOptions;
import net.dillon.speedrunnermod.tag.ModBiomeTags;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.MobSpawnSettings;

import java.util.ArrayList;
import java.util.List;

import static net.dillon.speedrunnermod.option.ModCommonOptions.isDoomMode;

public record EntitySpawnsLoader(LoaderMain main) {
    public static int MONSTERS_MODIFIED = 0;
    public static int CREATURES_MODIFIED = 0;
    public static int WATER_CREATURES_MODIFIED = 0;

    /**
     * Places all default monster spawns for a name.
     */
    public void putDefaultMonsters() {
        List<MobSpawnEntry> monsterSpawns = new ArrayList<>();

        monsterSpawns.add(MobSpawnEntry.ofMonster(
                "minecraft:spider",
                ModCommonOptions.doomOrDefault(75, 100),
                ModCommonOptions.doomOrDefault(1, 4),
                ModCommonOptions.doomOrDefault(5, 4)
        ));

        monsterSpawns.add(MobSpawnEntry.ofMonster(
                "minecraft:slime",
                ModCommonOptions.doomOrDefault(50, 100),
                1,
                4
        ));

        monsterSpawns.add(MobSpawnEntry.ofMonster(
                "minecraft:enderman",
                ModCommonOptions.doomOrDefault(25, 50),
                ModCommonOptions.doomOrDefault(1, 4),
                4
        ));

        monsterSpawns.add(MobSpawnEntry.ofMonster(
                "minecraft:witch",
                ModCommonOptions.doomOrDefault(50, 5),
                1,
                ModCommonOptions.doomOrDefault(4, 1)
        ));

        monsterSpawns.add(MobSpawnEntry.ofUnweighted(
                "minecraft:zombie",
                ModCommonOptions.doomOrDefault(1, 4),
                4
        ));
        monsterSpawns.add(MobSpawnEntry.ofUnweighted(
                "minecraft:creeper",
                ModCommonOptions.doomOrDefault(1, 2),
                4
        ));

        modifyDefaultMonsterSpawns(monsterSpawns);
        MONSTERS_MODIFIED++;
    }

    /**
     * Places all default creature spawns for a name.
     */
    public void putDefaultCreatures() {
        List<MobSpawnEntry> creatureEntries = new ArrayList<>();

        creatureEntries.add(MobSpawnEntry.ofCreature(
                "minecraft:cow",
                16,
                4,
                8
        ));

        creatureEntries.add(MobSpawnEntry.ofCreature(
                "minecraft:pig",
                12,
                4,
                8
        ));

        creatureEntries.add(MobSpawnEntry.ofCreature(
                "minecraft:sheep",
                8,
                4,
                8
        ));

        creatureEntries.add(MobSpawnEntry.ofCreature(
                "minecraft:chicken",
                8,
                4,
                8
        ));

        modifyDefaultCreatureSpawns(creatureEntries, "creature");
        CREATURES_MODIFIED++;
    }

    /**
     * Places all default water creature spawns for a name.
     */
    public void putDefaultWaterCreatures() {
        List<MobSpawnEntry> waterCreatureSpawns = new ArrayList<>();

        waterCreatureSpawns.add(MobSpawnEntry.of(
                "minecraft:dolphin",
                "water_creature",
                15,
                1,
                2
        ));

        modifyDefaultCreatureSpawns(waterCreatureSpawns, "water_creature");
        WATER_CREATURES_MODIFIED++;
    }

    /**
     * Modifies creature spawns.
     */
    public void modifyDefaultCreatureSpawns(List<MobSpawnEntry> creatureEntries, String creatureType) {
        modifyExistingCreatureSpawns(creatureEntries, main().getSpawnArray(creatureType));
    }

    /**
     * Modifies monster spawns.
     */
    public void modifyDefaultMonsterSpawns(List<MobSpawnEntry> monsterEntries) {
        modifyExistingMonsterSpawns(monsterEntries);

        if (isDoomMode()) {
            addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:vindicator",
                    100,
                    1,
                    4
            ));
            addNewSpawn(MobSpawnEntry.ofMonster(
                    "minecraft:evoker",
                    35,
                    1,
                    1
            ));
        }
    }

    /**
     * Modifies already existing creature spawns.
     */
    public void modifyExistingCreatureSpawns(List<MobSpawnEntry> entries, JsonArray creatureTypeArray) {
        modifyExistingSpawns(entries, creatureTypeArray);
    }

    /**
     * Modifies already existing monster spawns.
     */
    public void modifyExistingMonsterSpawns(List<MobSpawnEntry> entries) {
        modifyExistingSpawns(entries, main().getMonsterArray());
    }

    /**
     * Modifies an already existing spawn.
     */
    public void modifyExistingSpawns(List<MobSpawnEntry> entries, JsonArray spawnersArray) {
        if (spawnersArray == null) {
            return;
        }

        for (MobSpawnEntry entry : entries) {
            boolean foundEntry = false;

            for (JsonElement spawnerElement : spawnersArray) {
                JsonObject spawner = spawnerElement.getAsJsonObject();
                String mobType = spawner.get("type").getAsString();

                if (entry.mobId().equals(mobType)) {
                    putSpawn(entry, spawner);
                    foundEntry = true;
                    break;
                }
            }

            if (!foundEntry) {
                throw new RuntimeException("Could not find existing spawn '" + entry.mobId() + "' in biome!");
            }
        }
    }

    /**
     * Adds a new mob spawn.
     */
    public void addNewSpawn(MobSpawnEntry entry) {
        JsonArray spawnersArray = main().getSpawnArray(entry.spawnType());

        JsonObject spawn = new JsonObject();
        putSpawn(entry, spawn);

        spawnersArray.add(spawn);
    }

    /**
     * Puts or replaces a mob spawn.
     */
    public void putSpawn(MobSpawnEntry entry, JsonObject spawnType) {
        JsonObject count = new JsonObject();
        count.addProperty("type", "minecraft:uniform");
        count.addProperty("min_inclusive", entry.minInclusive());
        count.addProperty("max_inclusive", entry.maxInclusive());

        spawnType.addProperty("type", entry.mobId());
        if (entry.weight() != -1) {
            spawnType.addProperty("weight", entry.weight());
        }
        spawnType.add("count", count);
    }

    /**
     * A list of all biomes that should modify monster spawns.
     * @since 26.3
     * @see BiomeDefaultFeatures#commonSpawns(MobSpawnSettings.Builder)
     * @see ModBiomeTags#BIOMES_WITH_DEFAULT_MONSTERS
     */
    public static List<String> biomesWithDefaultMonsters() {
        return List.of(
                biome("deep_frozen_ocean"),
                biome("frozen_ocean"),
                biome("deep_cold_ocean"),
                biome("cold_ocean"),
                biome("deep_ocean"),
                biome("ocean"),
                biome("deep_lukewarm_ocean"),
                biome("lukewarm_ocean"),
                biome("warm_ocean"),
                biome("stony_shore"),
                biome("swamp"),
                biome("mangrove_swamp"),
                biome("snowy_slopes"),
                biome("snowy_plains"),
                biome("snowy_beach"),
                biome("windswept_gravelly_hills"),
                biome("grove"),
                biome("windswept_hills"),
                biome("snowy_taiga"),
                biome("windswept_forest"),
                biome("taiga"),
                biome("plains"),
                biome("meadow"),
                biome("beach"),
                biome("forest"),
                biome("old_growth_spruce_taiga"),
                biome("flower_forest"),
                biome("birch_forest"),
                biome("dark_forest"),
                biome("savanna_plateau"),
                biome("savanna"),
                biome("jungle"),
                biome("badlands"),
                biome("desert"),
                biome("wooded_badlands"),
                biome("jagged_peaks"),
                biome("frozen_river"),
                biome("river"),
                biome("ice_spikes"),
                biome("dappled_forest"),
                biome("old_growth_pine_taiga"),
                biome("sunflower_plains"),
                biome("old_growth_birch_forest"),
                biome("sparse_jungle"),
                biome("bamboo_jungle"),
                biome("eroded_badlands"),
                biome("windswept_savanna"),
                biome("cherry_grove"),
                biome("frozen_peaks"),
                biome("dripstone_caves")
        );
    }

    /**
     * A list of all biomes that should modify creature spawns.
     * @since 26.3
     * @see BiomeDefaultFeatures#farmAnimals(MobSpawnSettings.Builder)
     * @see ModBiomeTags#BIOMES_WITH_FARM_ANIMALS
     */
    public static List<String> biomesWithFarmAnimals() {
        return List.of(
                biome("plains"),
                biome("sunflower_plains"),
                biome("forest"),
                biome("flower_forest"),
                biome("birch_forest"),
                biome("old_growth_birch_forest"),
                biome("dappled_forest"),
                biome("dark_forest"),
                biome("windswept_hills"),
                biome("windswept_forest"),
                biome("windswept_gravelly_hills"),
                biome("bamboo_jungle"),
                biome("jungle"),
                biome("sparse_jungle"),
                biome("savanna"),
                biome("savanna_plateau"),
                biome("windswept_savanna"),
                biome("taiga"),
                biome("snowy_taiga"),
                biome("old_growth_pine_taiga"),
                biome("old_growth_spruce_taiga")
        );
    }

    /**
     * A list of all biomes that should modify water spawns.
     * @since 26.3
     * @see ModBiomeTags#BIOMES_WITH_WATER_ANIMALS
     */
    public static List<String> biomesWithWaterAnimals() {
        return List.of(
                biome("warm_ocean")
        );
    }

    /**
     * Returns the file name of the given name.
     */
    private static String biome(String name) {
        return "worldgen/biome/" + name + ".json";
    }
}