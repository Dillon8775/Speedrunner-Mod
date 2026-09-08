package net.dillon.speedrunnermod.data;

/**
 * Stores a mob spawn entry.
 */
public class MobSpawnEntry {
    private final String mobId;
    private final String spawnType;
    private final int weight;
    private final int minInclusive;
    private final int maxInclusive;

    private MobSpawnEntry(String mobId, String spawnType, int weight, int minInclusive, int maxInclusive) {
        this.mobId = mobId;
        this.spawnType = spawnType;
        this.weight = weight;
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
    }

    public static MobSpawnEntry of(String mobId, String spawnType, int weight, int minInclusive, int maxInclusive) {
        return new MobSpawnEntry(mobId, spawnType, weight, minInclusive, maxInclusive);
    }

    public static MobSpawnEntry ofMonster(String mobId, int weight, int minInclusive, int maxInclusive) {
        return of(mobId, "monster", weight, minInclusive, maxInclusive);
    }

    public static MobSpawnEntry ofCreature(String mobId, int weight, int minInclusive, int maxInclusive) {
        return of(mobId, "creature", weight, minInclusive, maxInclusive);
    }

    public static MobSpawnEntry ofUnweighted(String mobId, int minInclusive, int maxInclusive) {
        return of(mobId, "monster", -1, minInclusive, maxInclusive);
    }

    public String mobId() {
        return this.mobId;
    }

    public String spawnType() {
        return this.spawnType;
    }

    public int weight() {
        return this.weight;
    }

    public int minInclusive() {
        return this.minInclusive;
    }

    public int maxInclusive() {
        return this.maxInclusive;
    }
}