package net.dillon8775.speedrunnermod.block;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.dillon8775.speedrunnermod.util.ModSignType;
import net.dillon8775.speedrunnermod.world.gen.feature.tree.SpeedrunnerSaplingGenerator;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block SPEEDRUNNER_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block STRIPPED_SPEEDRUNNER_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_WOOD = new PillarBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block STRIPPED_SPEEDRUNNER_WOOD = new PillarBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES)
            .strength(0.1F)
            .nonOpaque()
            .ticksRandomly()
            .allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never)
            .blockVision(Blocks::never)
            .sounds(BlockSoundGroup.GRASS));

    public static final Block SPEEDRUNNER_SAPLING = new SpeedrunnerSaplingBlock(new SpeedrunnerSaplingGenerator(), FabricBlockSettings.of(Material.LEAVES)
            .breakInstantly()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block POTTED_SPEEDRUNNER_SAPLING = new FlowerPotBlock(SPEEDRUNNER_SAPLING, FabricBlockSettings.of(Material.DECORATION)
            .breakInstantly()
            .nonOpaque()
            .nonOpaque());

    public static final Block SPEEDRUNNER_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_SLAB = new SlabBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F, 6.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_STAIRS = new StairsBlock(SPEEDRUNNER_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_FENCE = new FenceBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.3F)
            .nonOpaque()
            .allowsSpawning(Blocks::never)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_SPEEDRUNNER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2.5F)
            .nonOpaque()
            .allowsSpawning(Blocks::never)
            .sounds(BlockSoundGroup.METAL));

    public static final Block SPEEDRUNNER_BUTTON = new WoodenButtonBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(0.35F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.WOOD)
            .strength(0.35F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_WEIGHTED_PRESSURE_PLATE = new WeightedPressurePlateBlock(100, FabricBlockSettings.of(Material.METAL)
            .requiresTool()
            .strength(0.5F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_DOOR = new DoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.3F)
            .nonOpaque()
            .sounds(BlockSoundGroup.WOOD));
    public static final Block REINFORCED_SPEEDRUNNER_DOOR = new DoorBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2.5F)
            .nonOpaque()
            .sounds(BlockSoundGroup.METAL));

    public static final Block SPEEDRUNNER_SIGN = new SignBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD), ModSignType.SPEEDRUNNER);

    public static final Block SPEEDRUNNER_WALL_SIGN = new WallSignBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD), ModSignType.SPEEDRUNNER);

    public static final Block DEAD_SPEEDRUNNER_BUSH = new DeadBushBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
            .breakInstantly()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block POTTED_DEAD_SPEEDRUNNER_BUSH = new FlowerPotBlock(DEAD_SPEEDRUNNER_BUSH, FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
            .breakInstantly()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));

    public static final Block SPEEDRUNNERS_WORKBENCH = new SpeedrunnersWorkbenchBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.6F)
            .sounds(BlockSoundGroup.WOOD));

    public static final Block SPEEDRUNNER_BLOCK = new ParticleBlock(FabricBlockSettings.of(Material.METAL)
            .requiresTool()
            .strength(5.0F, 6.0F)
            .sounds(BlockSoundGroup.METAL));

    public static final Block RAW_SPEEDRUNNER_BLOCK = new Block(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(5.0F, 6.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block SPEEDRUNNER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_SPEEDRUNNER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(4.5F, 4.5F)
            .sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block NETHER_SPEEDRUNNER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.NETHER_GOLD_ORE));

    public static final Block IGNEOUS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_IGNEOUS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(4.5F, 4.5F)
            .sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block NETHER_IGNEOUS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.NETHER_ORE));

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_log"), ModBlocks.SPEEDRUNNER_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "stripped_speedrunner_log"), ModBlocks.STRIPPED_SPEEDRUNNER_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_wood"), ModBlocks.SPEEDRUNNER_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "stripped_speedrunner_wood"), ModBlocks.STRIPPED_SPEEDRUNNER_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_leaves"), ModBlocks.SPEEDRUNNER_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_sapling"), ModBlocks.SPEEDRUNNER_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "potted_speedrunner_sapling"), ModBlocks.POTTED_SPEEDRUNNER_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_planks"), ModBlocks.SPEEDRUNNER_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_slab"), ModBlocks.SPEEDRUNNER_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_stairs"), ModBlocks.SPEEDRUNNER_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_fence"), ModBlocks.SPEEDRUNNER_FENCE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_fence_gate"), ModBlocks.SPEEDRUNNER_FENCE_GATE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_trapdoor"), ModBlocks.SPEEDRUNNER_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "reinforced_speedrunner_trapdoor"), ModBlocks.REINFORCED_SPEEDRUNNER_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_button"), ModBlocks.SPEEDRUNNER_BUTTON);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_pressure_plate"), ModBlocks.SPEEDRUNNER_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_weighted_pressure_plate"), ModBlocks.SPEEDRUNNER_WEIGHTED_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_door"), ModBlocks.SPEEDRUNNER_DOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "reinforced_speedrunner_door"), ModBlocks.REINFORCED_SPEEDRUNNER_DOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_sign"), ModBlocks.SPEEDRUNNER_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_wall_sign"), ModBlocks.SPEEDRUNNER_WALL_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "dead_speedrunner_bush"), ModBlocks.DEAD_SPEEDRUNNER_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "potted_dead_speedrunner_bush"), ModBlocks.POTTED_DEAD_SPEEDRUNNER_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunners_workbench"), ModBlocks.SPEEDRUNNERS_WORKBENCH);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_block"), ModBlocks.SPEEDRUNNER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "raw_speedrunner_block"), ModBlocks.RAW_SPEEDRUNNER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_ore"), ModBlocks.SPEEDRUNNER_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_speedrunner_ore"), ModBlocks.DEEPSLATE_SPEEDRUNNER_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "nether_speedrunner_ore"), ModBlocks.NETHER_SPEEDRUNNER_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "igneous_ore"), ModBlocks.IGNEOUS_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_igneous_ore"), ModBlocks.DEEPSLATE_IGNEOUS_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "nether_igneous_ore"), ModBlocks.NETHER_IGNEOUS_ORE);

        StrippableBlockRegistry.register(ModBlocks.SPEEDRUNNER_LOG, ModBlocks.STRIPPED_SPEEDRUNNER_LOG);
        StrippableBlockRegistry.register(ModBlocks.SPEEDRUNNER_WOOD, ModBlocks.STRIPPED_SPEEDRUNNER_WOOD);
    }

    @Environment(EnvType.CLIENT)
    public static void clinit() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REINFORCED_SPEEDRUNNER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REINFORCED_SPEEDRUNNER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_SPEEDRUNNER_BUSH, RenderLayer.getCutout());
    }
}