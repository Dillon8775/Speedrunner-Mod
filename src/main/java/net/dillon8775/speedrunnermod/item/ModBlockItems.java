package net.dillon8775.speedrunnermod.item;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.dillon8775.speedrunnermod.SpeedrunnerModClient;
import net.dillon8775.speedrunnermod.block.ModBlocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.info;

/**
 * {@link SpeedrunnerMod} block items.
 */
public class ModBlockItems {
    public static final BlockItem SPEEDRUNNER_LOG = new BlockItem(ModBlocks.SPEEDRUNNER_LOG,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem STRIPPED_SPEEDRUNNER_LOG = new BlockItem(ModBlocks.STRIPPED_SPEEDRUNNER_LOG,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SPEEDRUNNER_WOOD = new BlockItem(ModBlocks.SPEEDRUNNER_WOOD,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem STRIPPED_SPEEDRUNNER_WOOD = new BlockItem(ModBlocks.STRIPPED_SPEEDRUNNER_WOOD,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SPEEDRUNNER_LEAVES = new BlockItem(ModBlocks.SPEEDRUNNER_LEAVES,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.DECORATIONS));
    public static final BlockItem SPEEDRUNNER_SAPLING = new BlockItem(ModBlocks.SPEEDRUNNER_SAPLING,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.DECORATIONS));
    public static final BlockItem SPEEDRUNNER_PLANKS = new BlockItem(ModBlocks.SPEEDRUNNER_PLANKS,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SPEEDRUNNER_SLAB = new BlockItem(ModBlocks.SPEEDRUNNER_SLAB,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SPEEDRUNNER_STAIRS = new BlockItem(ModBlocks.SPEEDRUNNER_STAIRS,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SPEEDRUNNER_FENCE = new BlockItem(ModBlocks.SPEEDRUNNER_FENCE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.DECORATIONS));
    public static final BlockItem SPEEDRUNNER_FENCE_GATE = new BlockItem(ModBlocks.SPEEDRUNNER_FENCE_GATE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem WOODEN_SPEEDRUNNER_TRAPDOOR = new BlockItem(ModBlocks.WOODEN_SPEEDRUNNER_TRAPDOOR,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem SPEEDRUNNER_TRAPDOOR = new BlockItem(ModBlocks.SPEEDRUNNER_TRAPDOOR,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem SPEEDRUNNER_BUTTON = new BlockItem(ModBlocks.SPEEDRUNNER_BUTTON,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem SPEEDRUNNER_PRESSURE_PLATE = new BlockItem(ModBlocks.SPEEDRUNNER_PRESSURE_PLATE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem SPEEDRUNNER_WEIGHTED_PRESSURE_PLATE = new BlockItem(ModBlocks.SPEEDRUNNER_WEIGHTED_PRESSURE_PLATE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem WOODEN_SPEEDRUNNER_DOOR = new TallBlockItem(ModBlocks.WOODEN_SPEEDRUNNER_DOOR,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem SPEEDRUNNER_DOOR = new BlockItem(ModBlocks.SPEEDRUNNER_DOOR,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.REDSTONE));
    public static final BlockItem SPEEDRUNNER_SIGN = new SignItem(
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS).maxCount(16), ModBlocks.SPEEDRUNNER_SIGN, ModBlocks.SPEEDRUNNER_WALL_SIGN);
    public static final BlockItem DEAD_SPEEDRUNNER_BUSH = new BlockItem(ModBlocks.DEAD_SPEEDRUNNER_BUSH,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SPEEDRUNNERS_WORKBENCH = new BlockItem(ModBlocks.SPEEDRUNNERS_WORKBENCH,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.DECORATIONS)) {

        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            if (SpeedrunnerModClient.clientOptions().itemTooltips) {
                tooltip.add(new TranslatableText("item.speedrunnermod.speedrunners_workbench.tooltip.line1"));
                tooltip.add(new TranslatableText("item.speedrunnermod.speedrunners_workbench.tooltip.line2"));
                tooltip.add(new TranslatableText("item.speedrunnermod.speedrunners_workbench.tooltip.line3"));
            }
        }
    };
    public static final BlockItem SPEEDRUNNER_BLOCK = new BlockItem(ModBlocks.SPEEDRUNNER_BLOCK,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.MATERIALS));
    public static final BlockItem RAW_SPEEDRUNNER_BLOCK = new BlockItem(ModBlocks.RAW_SPEEDRUNNER_BLOCK,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.MATERIALS));
    public static final BlockItem SPEEDRUNNER_ORE = new BlockItem(ModBlocks.SPEEDRUNNER_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_SPEEDRUNNER_ORE = new BlockItem(ModBlocks.DEEPSLATE_SPEEDRUNNER_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem NETHER_SPEEDRUNNER_ORE = new BlockItem(ModBlocks.NETHER_SPEEDRUNNER_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem IGNEOUS_ORE = new BlockItem(ModBlocks.IGNEOUS_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_IGNEOUS_ORE = new BlockItem(ModBlocks.DEEPSLATE_IGNEOUS_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem NETHER_IGNEOUS_ORE = new BlockItem(ModBlocks.NETHER_IGNEOUS_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem EXPERIENCE_ORE = new BlockItem(ModBlocks.EXPERIENCE_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_EXPERIENCE_ORE = new BlockItem(ModBlocks.DEEPSLATE_EXPERIENCE_ORE,
            new Item.Settings().group(ModItemGroup.SPEEDRUNNER_MOD).group(ItemGroup.BUILDING_BLOCKS));

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_log"), SPEEDRUNNER_LOG);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "stripped_speedrunner_log"), STRIPPED_SPEEDRUNNER_LOG);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_wood"), SPEEDRUNNER_WOOD);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "stripped_speedrunner_wood"), STRIPPED_SPEEDRUNNER_WOOD);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_leaves"), SPEEDRUNNER_LEAVES);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_sapling"), SPEEDRUNNER_SAPLING);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_planks"), SPEEDRUNNER_PLANKS);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_slab"), SPEEDRUNNER_SLAB);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_stairs"), SPEEDRUNNER_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_fence"), SPEEDRUNNER_FENCE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_fence_gate"), SPEEDRUNNER_FENCE_GATE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "wooden_speedrunner_trapdoor"), WOODEN_SPEEDRUNNER_TRAPDOOR);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_trapdoor"), SPEEDRUNNER_TRAPDOOR);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_button"), SPEEDRUNNER_BUTTON);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_pressure_plate"), SPEEDRUNNER_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_weighted_pressure_plate"), SPEEDRUNNER_WEIGHTED_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "wooden_speedrunner_door"), WOODEN_SPEEDRUNNER_DOOR);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_door"), SPEEDRUNNER_DOOR);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_sign"), SPEEDRUNNER_SIGN);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "dead_speedrunner_bush"), DEAD_SPEEDRUNNER_BUSH);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunners_workbench"), SPEEDRUNNERS_WORKBENCH);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_block"), SPEEDRUNNER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "raw_speedrunner_block"), RAW_SPEEDRUNNER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "speedrunner_ore"), SPEEDRUNNER_ORE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_speedrunner_ore"), DEEPSLATE_SPEEDRUNNER_ORE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "nether_speedrunner_ore"), NETHER_SPEEDRUNNER_ORE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "igneous_ore"), IGNEOUS_ORE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_igneous_ore"), DEEPSLATE_IGNEOUS_ORE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "nether_igneous_ore"), NETHER_IGNEOUS_ORE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "experience_ore"), EXPERIENCE_ORE);
        Registry.register(Registry.ITEM, new Identifier(SpeedrunnerMod.MOD_ID, "deepslate_experience_ore"), DEEPSLATE_EXPERIENCE_ORE);

        info("Initialized block items.");
    }
}