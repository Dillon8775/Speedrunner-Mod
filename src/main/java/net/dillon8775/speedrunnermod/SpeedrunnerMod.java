package net.dillon8775.speedrunnermod;

import net.dillon8775.speedrunnermod.block.ModBlocks;
import net.dillon8775.speedrunnermod.item.ModFuels;
import net.dillon8775.speedrunnermod.item.ModItems;
import net.dillon8775.speedrunnermod.option.ModOptions;
import net.dillon8775.speedrunnermod.recipe.SpeedrunnerShieldDecorationRecipe;
import net.dillon8775.speedrunnermod.tag.ModBlockTags;
import net.dillon8775.speedrunnermod.tag.ModFluidTags;
import net.dillon8775.speedrunnermod.tag.ModItemTags;
import net.dillon8775.speedrunnermod.util.entity.ModVillagers;
import net.dillon8775.speedrunnermod.world.biome.ModBiomes;
import net.dillon8775.speedrunnermod.world.gen.ModWorldGen;
import net.dillon8775.speedrunnermod.world.gen.StructureSpawnRates;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.SpawnSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpeedrunnerMod implements ModInitializer {
    /**
     * <p>{@link StructureSpawnRates}
     * <p>{@link net.dillon8775.speedrunnermod.option.ModOptions.Main.StructureSpawnRate} Feature</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.worldgen.BiomeGeneration}
     * <p>Speedrunner's Wasteland Biome Spawning <i>and</i> Better Biomes configuration</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.worldgen.ModdedWorldGeneration}</p>
     * <p>Modified structure generation and "Custom Biomes" option.</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.entity.EntityMixin}, {@link net.dillon8775.speedrunnermod.mixin.main.boat.BoatEntityMixin} <i>and</i> {@link net.dillon8775.speedrunnermod.mixin.main.boat.BoatEntityTypeMixin} </p>
     * <p>Modded boats configuration and functions.</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.nether.AllowWaterInNether}</p>
     * <p>Allow water in the nether configuration.</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.block.MoreBlockXP} <i>and</i> {@link net.dillon8775.speedrunnermod.mixin.main.block.MoreBlockXPRedstone}</p>
     * <p>Particle effects on ores in the Speedrunner's Wasteland <i>and</i> fortune enchantment multiplier.</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.block.FasterBlockBreaking}
     * <p>Faster Block Breaking configurations</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.modes.ICarusAndInfiniPearlMode}
     * <p>iCarus Mode and InfiniPearl Mode</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.entity.GhastEntityShootFireballGoalMixin}
     * <p>Kill Ghast On Fireball feature</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.worldgen.StrongholdSettings}
     * <p>Stronghold Count <i>and</i> Stronghold Distance option configuration</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.entity.DragonPerchTime}
     * <p>Dragon Perch Time configuration</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.world.gen.feature.ModFeatures#makeAnimalsMoreCommon(SpawnSettings.Builder)} <i>and</i> {@link net.dillon8775.speedrunnermod.world.gen.feature.ModFeatures#makeDolphinsMoreCommon(SpawnSettings.Builder, int, int)}
     * <p>{@link net.dillon8775.speedrunnermod.option.ModOptions.Advanced.MobSpawningRate} configuration</p>
     * <p></p>
     * <p><b>For client options, refer to</b> {@link SpeedrunnerModClient}.</p>
     */
    public static final String MOD_ID = "speedrunnermod";
    public static final String MOD_VERSION = "v1.8";
    public static final String VERSION = "Version: " + MOD_VERSION;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Identifier SPEEDRUNNER_MOD_ICON = new Identifier("speedrunnermod:icon.png");
    public static final Identifier DISCORD_ICON = new Identifier("dillon8775:textures/discord.png");
    public static final Identifier WEBPAGE_ICON = new Identifier("dillon8775:textures/webpage.png");
    public static final Identifier DILLON8775_ICON = new Identifier("dillon8775:textures/dillon8775.png");
    public static final Identifier MANNYQUESO_ICON = new Identifier("dillon8775:textures/mannyqueso.png");
    public static final Identifier NUZLAND_ICON = new Identifier("dillon8775:textures/nuzland.png");

    public void onInitialize() {
        ModOptions.loadConfig();

        ModBlocks.init();
        ModItems.init();
        ModBlockTags.init();
        ModItemTags.init();
        ModFluidTags.init();
        ModFuels.init();
        ModBiomes.init();
        ModVillagers.init();
        SpeedrunnerShieldDecorationRecipe.init();

        if (SpeedrunnerMod.options().advanced.generateSpeedrunnerTrees) {
            ModWorldGen.init();
        }

        StructureSpawnRates.setValues();
        StructureSpawnRates.init();

        LOGGER.info("The Speedrunner Mod (" + MOD_VERSION + ")" + " has loaded.");
    }

    public static ModOptions options() {
        return ModOptions.OPTIONS;
    }

    /*
      Notes:

      Creating Features Screens:
      For 1 line, Y = 80
      For 2 lines, Y = 90, 110
      For 3 lines, Y = 80, 100, 120
      For 4 lines, Y = 70, 90, 110, 130
     */
}