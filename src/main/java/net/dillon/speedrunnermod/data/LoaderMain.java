package net.dillon.speedrunnermod.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Contains helper methods used to create certain objects and arrays in JSON files.
 */
public record LoaderMain(JsonElement rootJsonElement) {

    /**
     * @return an array for a monster spawn.
     */
    public JsonArray getMonsterArray() {
        return getSpawnArray("monster");
    }

    /**
     * @return an array for a creature spawn.
     */
    public JsonArray getCreatureArray() {
        return getSpawnArray("creature");
    }

    /**
     * @return an array for a spawnType spawn.
     */
    public JsonArray getSpawnArray(String type) {
        return getSpawnsByCategoryObj()
                .getAsJsonArray(type);
    }

    /**
     * @return the placements array.
     */
    public JsonArray getPlacementArray() {
        return rootJsonElement().getAsJsonObject()
                .getAsJsonArray("placement");
    }

    /**
     * @return the root attributes object in a biome.
     */
    public JsonObject getAttributesObj() {
        return rootJsonElement().getAsJsonObject()
                .getAsJsonObject("attributes");
    }

    /**
     * @return the effects object.
     */
    public JsonObject getEffectsObj() {
        return rootJsonElement().getAsJsonObject()
                .getAsJsonObject("effects");
    }

    /**
     * @return the spawns by category object.
     */
    public JsonObject getSpawnsByCategoryObj() {
        return getAttributesObj()
                .getAsJsonObject("minecraft:gameplay/natural_mob_spawns")
                .getAsJsonObject("argument")
                .getAsJsonObject("spawns_by_category");
    }
}