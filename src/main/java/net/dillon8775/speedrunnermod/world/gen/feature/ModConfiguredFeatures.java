package net.dillon8775.speedrunnermod.world.gen.feature;

import com.google.common.collect.ImmutableList;
import net.dillon8775.speedrunnermod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.*;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<TreeFeatureConfig, ?> DEFAULT_SPEEDRUNNER =
            ConfiguredFeatures.register("default_speedrunner",
                    Feature.TREE.configure(defaultSpeedrunner().build()));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> FANCY_SPEEDRUNNER =
            ConfiguredFeatures.register("fancy_speedrunner", Feature.TREE.configure(fancySpeedrunner().build()));

    public static final ConfiguredFeature<TreeFeatureConfig, ?> BIRCH_SPEEDRUNNER =
            ConfiguredFeatures.register("birch_speedrunner", Feature.TREE.configure(birchSpeedrunner().build()));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> SAVANNA_SPEEDRUNNER =
            ConfiguredFeatures.register("savanna_speedrunner", Feature.TREE.configure(savannaSpeedrunner().build()));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TAIGA_SPEEDRUNNER =
            ConfiguredFeatures.register("taiga_speedrunner", Feature.TREE.configure(taigaSpeedrunner().build()));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> MEGA_JUNGLE_SPEEDRUNNER_PLACED =
            ConfiguredFeatures.register("mega_jungle_speedrunner", Feature.TREE.configure(jungleSpeedrunner().build()));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> BIG_SPEEDRUNNER =
            ConfiguredFeatures.register("big_speedrunner", Feature.TREE.configure(
                    new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LOG),
                            new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LEAVES),
                            new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                            new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                            .ignoreVines()
                            .build()));
    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> PATCH_DEAD_SPEEDRUNNER_BUSH =
            ConfiguredFeatures.register("patch_dead_speedrunner_bush", Feature.RANDOM_PATCH.configure(
                    VegetationConfiguredFeatures.createRandomPatchFeatureConfig(BlockStateProvider.of(ModBlocks.DEAD_SPEEDRUNNER_BUSH), 4)));
    private static final List<OreFeatureConfig.Target> SPEEDRUNNER_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SPEEDRUNNER_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SPEEDRUNNER_ORE.getDefaultState()));
    private static final List<OreFeatureConfig.Target> IGNEOUS_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.IGNEOUS_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_IGNEOUS_ORE.getDefaultState()));
    protected static final ConfiguredFeature<?, ?> ORE_SPEEDRUNNER = ConfiguredFeatures.register("ore_speedrunner",
            Feature.ORE.configure(new OreFeatureConfig(SPEEDRUNNER_ORES, 9)));
    protected static final ConfiguredFeature<?, ?> ORE_SPEEDRUNNER_SMALL = ConfiguredFeatures.register("ore_speedrunner_small",
            Feature.ORE.configure(new OreFeatureConfig(SPEEDRUNNER_ORES, 4)));
    protected static final ConfiguredFeature<?, ?> ORE_NETHER_SPEEDRUNNER = ConfiguredFeatures.register("ore_nether_speedrunner",
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHER_SPEEDRUNNER_ORE.getDefaultState(), 10)));
    protected static final ConfiguredFeature<?, ?> ORE_IGNEOUS = ConfiguredFeatures.register("ore_igneous",
            Feature.ORE.configure(new OreFeatureConfig(IGNEOUS_ORES, 4)));
    protected static final ConfiguredFeature<?, ?> ORE_NETHER_IGNEOUS = ConfiguredFeatures.register("ore_nether_igneous",
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHER_IGNEOUS_ORE.getDefaultState(), 4)));

    private static TreeFeatureConfig.Builder defaultSpeedrunner() {
        return TreeConfiguredFeatures.builder(
                ModBlocks.SPEEDRUNNER_LOG, ModBlocks.SPEEDRUNNER_LEAVES, 4, 2, 0, 2)
                .ignoreVines();
    }

    private static TreeFeatureConfig.Builder fancySpeedrunner() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(
                ModBlocks.SPEEDRUNNER_LOG),
                new LargeOakTrunkPlacer(3, 11, 0), BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .ignoreVines();
    }

    public static class SpeedrunnersWasteland {
        public static final ConfiguredFeature<TreeFeatureConfig, ?> DEFAULT_SPEEDRUNNER =
                ConfiguredFeatures.register("default_speedrunner_speedrunners_wasteland",
                        Feature.TREE.configure(speedrunnersWasteland().build()));
        public static final ConfiguredFeature<TreeFeatureConfig, ?> FANCY_SPEEDRUNNER =
                ConfiguredFeatures.register("fancy_speedrunner_speedrunners_wasteland",
                        Feature.TREE.configure(fancySpeedrunnersWasteland().build()));
        public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> PATCH_RAW_SPEEDRUNNER_BLOCK =
                ConfiguredFeatures.register("patch_raw_speedrunner_block",
                        Feature.RANDOM_PATCH.configure(
                                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK.configure(
                                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RAW_SPEEDRUNNER_BLOCK))), List.of(Blocks.GRASS_BLOCK))));
        protected static final ConfiguredFeature<?, ?> ORE_SPEEDRUNNER = ConfiguredFeatures.register("ore_speedrunner_speedrunners_wasteland", Feature.ORE.configure(
                new OreFeatureConfig(SPEEDRUNNER_ORES, 12)));
        protected static final ConfiguredFeature<?, ?> ORE_SPEEDRUNNER_SMALL = ConfiguredFeatures.register("ore_speedrunner_small_speedrunners_wasteland", Feature.ORE.configure(
                new OreFeatureConfig(SPEEDRUNNER_ORES, 5)));
        protected static final ConfiguredFeature<?, ?> ORE_DIAMOND = ConfiguredFeatures.register("ore_diamond_speedrunners_wasteland",
                Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.DIAMOND_ORES, 8, 0.3f)));
        protected static final ConfiguredFeature<?, ?> ORE_DIAMOND_BURIED = ConfiguredFeatures.register("ore_diamond_buried_speedrunners_wasteland",
                Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.DIAMOND_ORES, 12, 1.0f)));

        private static TreeFeatureConfig.Builder speedrunnersWasteland() {
            return TreeConfiguredFeatures.builder(
                            ModBlocks.SPEEDRUNNER_LOG, ModBlocks.SPEEDRUNNER_LEAVES, 5, 3, 1, 3)
                    .ignoreVines();
        }

        private static TreeFeatureConfig.Builder fancySpeedrunnersWasteland() {
            return new TreeFeatureConfig.Builder(BlockStateProvider.of(
                    ModBlocks.SPEEDRUNNER_LOG),
                    new LargeOakTrunkPlacer(3, 13, 0), BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LEAVES),
                    new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                    new TwoLayersFeatureSize(0, 1, 0, OptionalInt.of(4)))
                    .ignoreVines();
        }
    }

    private static TreeFeatureConfig.Builder birchSpeedrunner() {
        return TreeConfiguredFeatures.builder(
                ModBlocks.SPEEDRUNNER_LOG, ModBlocks.SPEEDRUNNER_LEAVES, 5, 2, 6, 2).ignoreVines();
    }

    private static TreeFeatureConfig.Builder savannaSpeedrunner() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LOG),
                new ForkingTrunkPlacer(5, 2, 2),
                BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LEAVES),
                new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines();
    }

    private static TreeFeatureConfig.Builder taigaSpeedrunner() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LOG),
                new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LEAVES),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2))
                .ignoreVines();
    }

    private static TreeFeatureConfig.Builder jungleSpeedrunner() {
        return new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LOG),
                new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.of(ModBlocks.SPEEDRUNNER_LEAVES),
                new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeavesVineTreeDecorator.INSTANCE));
    }
}