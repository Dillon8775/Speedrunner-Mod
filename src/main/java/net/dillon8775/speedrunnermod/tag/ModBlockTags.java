package net.dillon8775.speedrunnermod.tag;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.info;

/**
 * {@link SpeedrunnerMod} block tags. Useful for many things in some mixins.
 */
public class ModBlockTags {
    public static TagKey<Block> SPEEDRUNNER_ORES = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_ores"));
    public static TagKey<Block> IGNEOUS_ORES = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "igneous_ores"));
    public static TagKey<Block> SPEEDRUNNER_LOGS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_logs"));
    public static TagKey<Block> SPEEDRUNNER_PARTICLE_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_particle_blocks"));
    public static TagKey<Block> EXPERIENCE_ORES = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "experience_ores"));
    public static TagKey<Block> SPEEDRUNNER_SAPLING_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_sapling_blocks"));
    public static TagKey<Block> NETHER_PORTAL_BASE_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "nether_portal_base_blocks"));
    public static TagKey<Block> SMITHING_TABLES = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "smithing_tables"));
    public static TagKey<Block> SPEEDRUNNER_FUELS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_fuels"));
    public static TagKey<Block> FIREPROOF_BOAT_BASE_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "fireproof_boat_base_blocks"));
    public static TagKey<Block> FASTER_BOAT_BASE_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "faster_boat_base_blocks"));

    public static class BlockHardness {
        public static TagKey<Block> ZERO_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0_hardness"));
        public static TagKey<Block> ZERO_ONE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-1_hardness"));
        public static TagKey<Block> ZERO_TWO_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-2_hardness"));
        public static TagKey<Block> ZERO_THREEFIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-35_hardness"));
        public static TagKey<Block> ZERO_THREESEVEN_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-37_hardness"));
        public static TagKey<Block> ZERO_FOUR_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-4_hardness"));
        public static TagKey<Block> ZERO_FIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-5_hardness"));
        public static TagKey<Block> ZERO_SIX_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-6_hardness"));
        public static TagKey<Block> ZERO_SIXFIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-65_hardness"));
        public static TagKey<Block> ZERO_SEVEN_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-7_hardness"));
        public static TagKey<Block> ZERO_EIGHT_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/0-8_hardness"));
        public static TagKey<Block> ONE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/1_hardness"));
        public static TagKey<Block> ONE_THREE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/1-3_hardness"));
        public static TagKey<Block> ONE_FOUR_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/1-4_hardness"));
        public static TagKey<Block> ONE_FIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/1-5_hardness"));
        public static TagKey<Block> ONE_SIX_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/1-6_hardness"));
        public static TagKey<Block> TWO_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/2_hardness"));
        public static TagKey<Block> TWO_FIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/2-5_hardness"));
        public static TagKey<Block> THREE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/3_hardness"));
        public static TagKey<Block> FOUR_FIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/4-5_hardness"));
        public static TagKey<Block> FIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/5_hardness"));
        public static TagKey<Block> SIX_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/6_hardness"));
        public static TagKey<Block> SEVEN_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/7_hardness"));
        public static TagKey<Block> EIGHT_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/8_hardness"));
        public static TagKey<Block> NINE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/9_hardness"));
        public static TagKey<Block> TEN_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/10_hardness"));
        public static TagKey<Block> TWENTY_FIVE_HARDNESS = TagKey.of(Registry.BLOCK_KEY, new Identifier(SpeedrunnerMod.MOD_ID, "block_hardness/25_hardness"));
    }

    public static void init() {
        info("Initialized block tags.");
    }
}