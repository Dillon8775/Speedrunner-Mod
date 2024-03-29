package net.dillon8775.speedrunnermod.block;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.dillon8775.speedrunnermod.util.ModSignTypes;
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

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.info;

/**
 * The {@code Speedrunner Mod} blocks.
 */
public class ModBlocks {
    public static final Block SPEEDRUNNER_LOG = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block STRIPPED_SPEEDRUNNER_LOG = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_WOOD = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block STRIPPED_SPEEDRUNNER_WOOD = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block DEAD_SPEEDRUNNER_LOG = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block DEAD_STRIPPED_SPEEDRUNNER_LOG = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block DEAD_SPEEDRUNNER_WOOD = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block DEAD_STRIPPED_SPEEDRUNNER_WOOD = new PillarBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
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
    public static final Block DEAD_SPEEDRUNNER_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES)
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
    public static final Block SPEEDRUNNER_PLANKS = new Block(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_SLAB = new SlabBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F, 6.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_STAIRS = new StairsBlock(SPEEDRUNNER_PLANKS.getDefaultState(), FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_FENCE = new FenceBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block WOODEN_SPEEDRUNNER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.3F)
            .nonOpaque()
            .allowsSpawning(Blocks::never)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.of(Material.METAL)
            .requiresTool()
            .strength(2.5F)
            .nonOpaque()
            .allowsSpawning(Blocks::never)
            .sounds(BlockSoundGroup.METAL));
    public static final Block SPEEDRUNNER_BUTTON = new WoodenButtonBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(0.35F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD));
    public static final Block WOODEN_SPEEDRUNNER_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(0.35F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_WEIGHTED_PRESSURE_PLATE = new WeightedPressurePlateBlock(100, FabricBlockSettings.of(Material.METAL)
            .requiresTool()
            .strength(0.5F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD));
    public static final Block WOODEN_SPEEDRUNNER_DOOR = new DoorBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.3F)
            .nonOpaque()
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_DOOR = new DoorBlock(FabricBlockSettings.of(Material.METAL)
            .requiresTool()
            .strength(2.5F)
            .nonOpaque()
            .sounds(BlockSoundGroup.METAL));
    public static final Block SPEEDRUNNER_SIGN = new SignBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD), ModSignTypes.SPEEDRUNNER);
    public static final Block SPEEDRUNNER_WALL_SIGN = new WallSignBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.0F)
            .noCollision()
            .sounds(BlockSoundGroup.WOOD), ModSignTypes.SPEEDRUNNER);
    public static final Block DEAD_SPEEDRUNNER_BUSH = new DeadBushBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
            .breakInstantly()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));
    public static final Block POTTED_DEAD_SPEEDRUNNER_BUSH = new FlowerPotBlock(DEAD_SPEEDRUNNER_BUSH, FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
            .breakInstantly()
            .noCollision()
            .sounds(BlockSoundGroup.GRASS));
    public static final Block SPEEDRUNNERS_WORKBENCH = new SpeedrunnersWorkbenchBlock(FabricBlockSettings.of(ModMaterials.SPEEDRUNNER_WOOD)
            .strength(1.6F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block SPEEDRUNNER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
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
    public static final Block EXPERIENCE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(5.0F, 10.0F)
            .sounds(BlockSoundGroup.STONE));
    public static final Block DEEPSLATE_EXPERIENCE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(6.0F, 12.5F)
            .sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block NETHER_EXPERIENCE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(3.0F, 3.0F)
            .sounds(BlockSoundGroup.NETHER_ORE));

    public static final Block DOOM_STONE = new DoomBlock.Default(FabricBlockSettings.of(Material.STONE)
            .requiresTool()
            .strength(1.5F, 3600000.0F)
            .sounds(BlockSoundGroup.STONE));
    public static final Block DOOM_LOG = new DoomBlock.Pillar(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F, 3600000.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block STRIPPED_DOOM_LOG = new DoomBlock.Pillar(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0F, 3600000.0F)
            .sounds(BlockSoundGroup.WOOD));
    public static final Block DOOM_LEAVES = new DoomBlock.Leaves(FabricBlockSettings.of(Material.LEAVES)
            .strength(0.1F, 3600000.0F)
            .nonOpaque()
            .ticksRandomly()
            .suffocates(Blocks::never)
            .blockVision(Blocks::never)
            .sounds(BlockSoundGroup.GRASS));

    /**
     * Makes certain blocks strippable.
     */
    private static void registerStrippables() {
        StrippableBlockRegistry.register(SPEEDRUNNER_LOG, STRIPPED_SPEEDRUNNER_LOG);
        StrippableBlockRegistry.register(SPEEDRUNNER_WOOD, STRIPPED_SPEEDRUNNER_WOOD);
        StrippableBlockRegistry.register(DOOM_LOG, STRIPPED_DOOM_LOG);
    }

    /**
     * Initialize the {@code Speedrunner Mod} blocks.
     */
    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_log"), SPEEDRUNNER_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "stripped_speedrunner_log"), STRIPPED_SPEEDRUNNER_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_wood"), SPEEDRUNNER_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "stripped_speedrunner_wood"), STRIPPED_SPEEDRUNNER_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "dead_speedrunner_log"), DEAD_SPEEDRUNNER_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "dead_stripped_speedrunner_log"), DEAD_STRIPPED_SPEEDRUNNER_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "dead_speedrunner_wood"), DEAD_SPEEDRUNNER_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "dead_stripped_speedrunner_wood"), DEAD_STRIPPED_SPEEDRUNNER_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_leaves"), SPEEDRUNNER_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "dead_speedrunner_leaves"), DEAD_SPEEDRUNNER_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_sapling"), SPEEDRUNNER_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "potted_speedrunner_sapling"), POTTED_SPEEDRUNNER_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_planks"), SPEEDRUNNER_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_slab"), SPEEDRUNNER_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_stairs"), SPEEDRUNNER_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_fence"), SPEEDRUNNER_FENCE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_fence_gate"), SPEEDRUNNER_FENCE_GATE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "wooden_speedrunner_trapdoor"), WOODEN_SPEEDRUNNER_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_trapdoor"), SPEEDRUNNER_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_button"), SPEEDRUNNER_BUTTON);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "wooden_speedrunner_pressure_plate"), WOODEN_SPEEDRUNNER_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_weighted_pressure_plate"), SPEEDRUNNER_WEIGHTED_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "wooden_speedrunner_door"), WOODEN_SPEEDRUNNER_DOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_door"), SPEEDRUNNER_DOOR);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_sign"), SPEEDRUNNER_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_wall_sign"), SPEEDRUNNER_WALL_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "dead_speedrunner_bush"), DEAD_SPEEDRUNNER_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "potted_dead_speedrunner_bush"), POTTED_DEAD_SPEEDRUNNER_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunners_workbench"), SPEEDRUNNERS_WORKBENCH);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_block"), SPEEDRUNNER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "raw_speedrunner_block"), RAW_SPEEDRUNNER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_ore"), SPEEDRUNNER_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_speedrunner_ore"), DEEPSLATE_SPEEDRUNNER_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "nether_speedrunner_ore"), NETHER_SPEEDRUNNER_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "igneous_ore"), IGNEOUS_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_igneous_ore"), DEEPSLATE_IGNEOUS_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "nether_igneous_ore"), NETHER_IGNEOUS_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "experience_ore"), EXPERIENCE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_experience_ore"), DEEPSLATE_EXPERIENCE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "nether_experience_ore"), NETHER_EXPERIENCE_ORE);

        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "doom_stone"), DOOM_STONE);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "doom_log"), DOOM_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "stripped_doom_log"), STRIPPED_DOOM_LOG);
        Registry.register(Registry.BLOCK, new Identifier(SpeedrunnerMod.MOD_ID, "doom_leaves"), DOOM_LEAVES);

        registerStrippables();

        info("Initialized blocks.");
    }

    /**
     * Initialize custom block renderers.
     */
    @Environment(EnvType.CLIENT)
    public static void clinit() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DOOM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODEN_SPEEDRUNNER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODEN_SPEEDRUNNER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPEEDRUNNER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_SPEEDRUNNER_BUSH, RenderLayer.getCutout());

        info("Initialized custom block models.");
    }
}