package net.dillon8775.speedrunnermod;

import net.dillon8775.speedrunnermod.block.ModBlocks;
import net.dillon8775.speedrunnermod.block.ModMaterials;
import net.dillon8775.speedrunnermod.enchantment.ModEnchantments;
import net.dillon8775.speedrunnermod.entity.ModEntityTypes;
import net.dillon8775.speedrunnermod.item.ModBlockItems;
import net.dillon8775.speedrunnermod.item.ModFuels;
import net.dillon8775.speedrunnermod.item.ModItemGroups;
import net.dillon8775.speedrunnermod.item.ModItems;
import net.dillon8775.speedrunnermod.mixin.main.entity.DragonPerchTime;
import net.dillon8775.speedrunnermod.mixin.main.entity.player.ServerPlayerEntityMixin;
import net.dillon8775.speedrunnermod.mixin.main.world.VanillaBiomeParametersMixin;
import net.dillon8775.speedrunnermod.option.Leaderboards;
import net.dillon8775.speedrunnermod.option.ModOptions;
import net.dillon8775.speedrunnermod.recipe.ModRecipes;
import net.dillon8775.speedrunnermod.sound.ModSoundEvents;
import net.dillon8775.speedrunnermod.tag.ModBlockTags;
import net.dillon8775.speedrunnermod.tag.ModConfiguredFeatureTags;
import net.dillon8775.speedrunnermod.tag.ModFluidTags;
import net.dillon8775.speedrunnermod.tag.ModItemTags;
import net.dillon8775.speedrunnermod.util.MathUtil;
import net.dillon8775.speedrunnermod.util.ModSignTypes;
import net.dillon8775.speedrunnermod.village.ModTradeOffers;
import net.dillon8775.speedrunnermod.village.ModVillagerProfessions;
import net.dillon8775.speedrunnermod.world.ModFeatures;
import net.dillon8775.speedrunnermod.world.ModWorldGen;
import net.dillon8775.speedrunnermod.world.biome.ModBiomes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.SpawnSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.dillon8775.speedrunnermod.option.ModOptions.createListOption;

/**
 * The main class file for {@code The Speedrunner Mod}.
 */
public class SpeedrunnerMod implements ModInitializer {
    /**
     * <p>{@link VanillaBiomeParametersMixin}
     * <p>Speedrunner's Wasteland Biome Spawning <i>and</i> Better Biomes configuration</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.entity.basic.EntityMixin}, {@link net.dillon8775.speedrunnermod.mixin.main.boat.BoatEntityMixin} <i>and</i> {@link net.dillon8775.speedrunnermod.mixin.main.boat.BoatEntityTypeMixin} </p>
     * <p>Modded boats configuration and functions.</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.nether.AllowWaterInNether}</p>
     * <p>Allow water in the nether configuration.</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.block.FasterBlockBreaking}
     * <p>Faster Block Breaking configurations</p>
     * <p></p>
     * <p>{@link ServerPlayerEntityMixin}
     * <p>iCarus Mode and InfiniPearl Mode</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.entity.GhastEntityShootFireballGoalMixin}
     * <p>Kill Ghast On Fireball feature</p>
     * <p></p>
     * <p>{@link net.dillon8775.speedrunnermod.mixin.main.world.StructureSetsMixin}
     * <p>Stronghold Count <i>and</i> Stronghold Distance option configuration</p>
     * <p></p>
     * <p>{@link DragonPerchTime}
     * <p>Dragon Perch Time configuration</p>
     * <p></p>
     * <p>{@link ModFeatures#makeAnimalsMoreCommon(SpawnSettings.Builder)} <i>and</i> {@link ModFeatures#makeDolphinsMoreCommon(SpawnSettings.Builder, int, int)}
     * <p>{@link net.dillon8775.speedrunnermod.option.ModOptions.MobSpawningRate} configuration</p>
     * <p></p>
     * <p><b>For client options, refer to</b> {@link SpeedrunnerModClient}.</p>
     */
    public static final String MOD_ID = "speedrunnermod";
    public static final String MOD_VERSION = "v1.9";
    public static final String VERSION = "Version: " + MOD_VERSION;
    public static final String THE_SPEEDRUNNER_MOD_STRING = "The Speedrunner Mod";
    public static final String WIKI_LINK = "https://sites.google.com/view/dillon8775/the-speedrunner-mod";
    public static boolean DOOM_MODE = SpeedrunnerMod.options().main.doomMode;
    public static final Identifier SPEEDRUNNER_MOD_ICON = new Identifier("speedrunnermod:icon.png");
    public static final Identifier DISCORD_ICON = new Identifier("dillon8775:textures/discord.png");
    public static final Identifier WEBPAGE_ICON = new Identifier("dillon8775:textures/webpage.png");
    public static final Identifier DILLON8775_ICON = new Identifier("dillon8775:textures/dillon8775.png");
    public static final Identifier MANNYQUESO_ICON = new Identifier("dillon8775:textures/mannyqueso.png");
    public static final Identifier NUZLAND_ICON = new Identifier("dillon8775:textures/nuzland.png");
    public static final String OPTIONS_ERROR_MESSAGE = "Found error with speedrunner mod settings, launching in safe mode.";
    public static final String OPTIONS_WARNING_MESSAGE = "Found an unusual value in the speedrunner mod settings.";
    public static boolean safeBoot;
    private static final Logger LOGGER = LogManager.getLogger("Speedrunner Mod");

    /**
     * <p>Initializes all the {@code Speedrunner Mod} features, items, blocks, etc.</p>
     * <p>This does not include any {@link org.spongepowered.asm.mixin.Mixins}.</p>
     */
    @Override
    public void onInitialize() {
        ModEntityTypes.init();

        ModMaterials.init();
        ModSignTypes.init();
        ModBlocks.init();
        ModItemGroups.init();
        ModBlockItems.init();
        ModItems.init();

        ModBiomes.init();

        ModConfiguredFeatureTags.init();
        ModBlockTags.init();
        ModItemTags.init();
        ModFluidTags.init();

        ModSoundEvents.init();

        ModEnchantments.init();
        ModRecipes.init();
        ModFuels.init();

        ModVillagerProfessions.init();
        ModTradeOffers.init();

        ModWorldGen.init();

        safeBoot = false;
        ModOptions.loadConfig();

        if (DOOM_MODE) {
            info("You dare to attempt Doom Mode? Good luck...");
        }

        Leaderboards.init();

        info("The Speedrunner Mod (" + MOD_VERSION + ")" + " has successfully initialized!");
    }

    /**
     * Sends an {@code info} message in console.
     */
    public static void info(String info) {
        LOGGER.info(info);
    }

    /**
     * Sends a {@code warning} message in console.
     */
    public static void warn(String warning) {
        LOGGER.warn(warning);
    }

    /**
     * Sends a {@code error} message in console.
     */
    public static void error(String error) {
        LOGGER.error(error);
    }

    /**
     * Sends a {@code debug} message in console.
     */
    public static void debug(String debug) {
        LOGGER.debug(debug);
    }

     /**
     * The {@code Speedrunner Mod} options method.
     */
    public static ModOptions options() {
        return ModOptions.OPTIONS;
    }

    /**
     * Resets all of the {@code speedrunner mod options} back to the default settings.
     */
    @Environment(EnvType.CLIENT)
    public static void resetOptions() {
        options().main.structureSpawnRates = ModOptions.StructureSpawnRates.COMMON;
        options().main.fasterBlockBreaking = true;
        options().main.blockBreakingMultiplier = 1;
        options().main.betterBiomes = true;
        options().main.iCarusMode = false;
        options().main.infiniPearlMode = false;
        options().main.leaderboardsMode = false;
        options().main.doomMode = false;
        options().main.dragonPerchTime = 8;
        options().main.killGhastOnFireball = false;
        options().main.betterVillagerTrades = true;
        options().main.fireproofItems = true;
        options().main.customBiomes = true;
        options().main.commonOres = true;
        options().main.lavaBoats = true;
        options().main.netherWater = false;
        options().main.betterFoods = true;
        options().main.fallDamage = true;
        options().main.kineticDamage = true;
        options().main.strongholdDistance = 4;
        options().main.strongholdSpread = 3;
        options().main.strongholdCount = 128;
        options().main.strongholdPortalRoomCount = 3;
        options().main.strongholdLibraryCount = 2;
        options().main.mobSpawningRate = ModOptions.MobSpawningRate.HIGH;
        options().main.mobSpawnerMinimumSpawnDuration = 20;
        options().main.mobSpawnerMaximumSpawnDuration = 40;
        options().main.netherPortalCooldown = 2;
        options().main.throwableFireballs = true;
        options().main.arrowsDestroyBeds = false;
        options().main.globalNetherPortals = true;
        options().main.betterAnvil = true;
        options().main.anvilCostLimit = 40;
        options().main.higherEnchantmentLevels = true;
        options().main.stackUnstackables = false;

        options().client.fog = true;
        options().client.itemTooltips = true;
        options().client.panorama = ModOptions.Panorama.SPEEDRUNNER_MOD;
        options().client.itemMessages = ModOptions.ItemMessages.ACTIONBAR;
        options().client.confirmMessages = false;
        options().client.modButtonType = ModOptions.ModButtonType.LOGO;
        options().client.socialButtons = true;
        options().client.fastWorldCreation = true;
        options().client.gameMode = ModOptions.GameMode.SURVIVAL;
        options().client.difficulty = ModOptions.Difficulty.EASY;
        options().client.allowCheats = false;
        options().client.showDeathCords = true;

        options().advanced.disableDragonsPearl = false;
        options().advanced.disableDragonsSword = false;
        options().advanced.disableEnderThruster = false;
        options().advanced.disablePiglinAwakener = false;
        options().advanced.disableBlazeSpotter = false;
        options().advanced.disableRaidEradicator = false;
        options().advanced.modifiedStrongholdGeneration = true;
        options().advanced.modifiedStrongholdYGeneration = true;
        options().advanced.modifiedNetherFortressGeneration = true;
        options().advanced.disableEyeOfAnnulPortalRoomTeleporter = false;
        options().advanced.enableEyeOfAnnulPortalRoomTeleporterOnDoomMode = true;
        options().advanced.removeSilkTouchWhenRightClick = true;
        options().advanced.fixSpeedrunnerEditionTextOffset = true;
        options().advanced.showResetButton = true;
        options().advanced.higherBreathTime = true;
        options().advanced.generateSpeedrunnerWood = true;
        options().advanced.longerDragonPerchStayTime = true;
        options().advanced.decreasedZombifiedPiglinScareDistance = true;
        options().advanced.eyeOfEnderBreakingCooldown = 40;
        options().advanced.piglinAwakenerPiglinCount = 10;
        options().advanced.teleportPiglinDirectlyTowardsPlayer = false;
        options().advanced.throwableFireballsExplosionPower = 1;
        options().advanced.dragonKillsNearbyHostileEntities = true;
        options().advanced.dragonImmunityFromGiantAndWither = true;
        options().advanced.annulEyePortalRoomDistanceXYZ = createListOption(-128, -128, -128, 128, 128, 128);
        options().advanced.piglinAwakenerPiglinDistanceXYZ = createListOption(100.0D, 100.0D, 100.0D);
        options().advanced.blazeSpotterDistanceXYZ = createListOption(-156, -72, -156, 156, 72, 156);
        options().advanced.raidEradicatorDistanceXYZ = createListOption(300.0D, 300.0D, 300.0D);
        options().advanced.dragonsPearlDragonDistanceXYZ = createListOption(150.0D, 150.0D, 150.0D);
        options().advanced.dragonKillsHostileEntitiesDistance = createListOption(200.0D, 200.0D, 200.0D);
        options().advanced.dragonImmunityDetectionDistanceForGiant = createListOption(200.0D, 200.0D, 200.0D);
        options().advanced.dragonImmunityDetectionDistanceForWither = createListOption(300.0D, 300.0D, 300.0D);
    }

    /**
     * Gets the player's death coordinates.
     */
    public static TranslatableText deathCords(double x, double y, double z) {
        return new TranslatableText("speedrunnermod.player_death_cords", MathUtil.roundToOneDecimalPlace(x), MathUtil.roundToOneDecimalPlace(y), MathUtil.roundToOneDecimalPlace(z));
    }

    /**
     * See {@link net.dillon8775.speedrunnermod.mixin.main.world.StructureSetsMixin} for more.
     * <p>Because of the way Minecraft changed structure generation in {@code 1.18.2}, we have to locally assign our values to these variables, because using my custom-created method {@code setStructureConfig} no longer works.</p>
     */
    public static int getVillageSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 4;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 10;
        } else if (options().main.structureSpawnRates.common()) {
            return 16;
        } else if (options().main.structureSpawnRates.normal()) {
            return 20;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 32;
        } else if (options().main.structureSpawnRates.rare()) {
            return 42;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 52;
        } else {
            return 0;
        }
    }

    public static int getVillageSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.common()) {
            return 9;
        } else if (options().main.structureSpawnRates.commonNormalOrDefault()) {
            return 8;
        } else if (options().main.structureSpawnRates.rare()) {
            return 10;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 16;
        } else {
            return 0;
        }
    }

    public static int getDesertPyramidSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 3;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 8;
        } else if (options().main.structureSpawnRates.common()) {
            return 10;
        } else if (options().main.structureSpawnRates.normal()) {
            return 20;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 32;
        } else if (options().main.structureSpawnRates.rare()) {
            return 42;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 52;
        } else {
            return 0;
        }
    }

    public static int getDesertPyramidSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 7;
        } else if (options().main.structureSpawnRates.commonNormalOrDefault()) {
            return 8;
        } else if (options().main.structureSpawnRates.rare()) {
            return 10;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 16;
        } else {
            return 0;
        }
    }

    public static int getJunglePyramidSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 3;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 8;
        } else if (options().main.structureSpawnRates.common()) {
            return 10;
        } else if (options().main.structureSpawnRates.normal()) {
            return 20;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 32;
        } else if (options().main.structureSpawnRates.rare()) {
            return 40;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 50;
        } else {
            return 0;
        }
    }

    public static int getJunglePyramidSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 7;
        } else if (options().main.structureSpawnRates.commonNormalOrDefault()) {
            return 8;
        } else if (options().main.structureSpawnRates.rare()) {
            return 10;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 12;
        } else {
            return 0;
        }
    }

    public static int getPillagerOutpostSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 3;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 8;
        } else if (options().main.structureSpawnRates.common()) {
            return 10;
        } else if (options().main.structureSpawnRates.normal()) {
            return 20;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 32;
        } else if (options().main.structureSpawnRates.rare()) {
            return 40;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 50;
        } else {
            return 0;
        }
    }

    public static int getPillagerOutpostSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 7;
        } else if (options().main.structureSpawnRates.commonNormalOrDefault()) {
            return 8;
        } else if (options().main.structureSpawnRates.rare()) {
            return 10;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 12;
        } else {
            return 0;
        }
    }

    public static int getEndCitySpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 4;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 5;
        } else if (options().main.structureSpawnRates.common()) {
            return 7;
        } else if (options().main.structureSpawnRates.normal()) {
            return 15;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 20;
        } else if (options().main.structureSpawnRates.rare()) {
            return 25;
        } else {
            return 0;
        }
    }

    public static int getEndCitySeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 4;
        } else if (options().main.structureSpawnRates.common()) {
            return 6;
        } else if (options().main.structureSpawnRates.normal()) {
            return 10;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 11;
        } else if (options().main.structureSpawnRates.rare()) {
            return 16;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 18;
        } else {
            return 0;
        }
    }

    public static int getWoodlandMansionSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 6;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 16;
        } else if (options().main.structureSpawnRates.common()) {
            return 25;
        } else if (options().main.structureSpawnRates.normal()) {
            return 40;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 80;
        } else if (options().main.structureSpawnRates.rare()) {
            return 100;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 120;
        } else {
            return 0;
        }
    }

    public static int getWoodlandMansionSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 4;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 8;
        } else if (options().main.structureSpawnRates.commonNormalOrDefault() || options().main.structureSpawnRates.rare()) {
            return 20;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 25;
        } else {
            return 0;
        }
    }

    public static int getRuinedPortalSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 4;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 7;
        } else if (options().main.structureSpawnRates.common()) {
            return 9;
        } else if (options().main.structureSpawnRates.normal()) {
            return 16;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 40;
        } else if (options().main.structureSpawnRates.rare()) {
            return 50;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 60;
        } else {
            return 0;
        }
    }

    public static int getRuinedPortalSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 6;
        } else if (options().main.structureSpawnRates.common()) {
            return 8;
        } else if (options().main.structureSpawnRates.normal()) {
            return 9;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 15;
        } else if (options().main.structureSpawnRates.rare()) {
            return 16;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 20;
        } else {
            return 0;
        }
    }

    public static int getShipwreckSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 3;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 8;
        } else if (options().main.structureSpawnRates.common()) {
            return 10;
        } else if (options().main.structureSpawnRates.normal()) {
            return 20;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 24;
        } else if (options().main.structureSpawnRates.rare()) {
            return 30;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 40;
        } else {
            return 0;
        }
    }

    public static int getShipwreckSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 7;
        } else if (options().main.structureSpawnRates.common() ||
                options().main.structureSpawnRates.normal()) {
            return 8;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 4;
        } else if (options().main.structureSpawnRates.rare()) {
            return 9;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 10;
        } else {
            return 0;
        }
    }

    public static int getNetherComplexesSpacing() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 4;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 6;
        } else if (options().main.structureSpawnRates.common()) {
            return 8;
        } else if (options().main.structureSpawnRates.normal()) {
            return 15;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 27;
        } else if (options().main.structureSpawnRates.rare()) {
            return 34;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 40;
        } else {
            return 0;
        }
    }

    public static int getNetherComplexesSeparation() {
        if (options().main.structureSpawnRates.everywhere()) {
            return 2;
        } else if (options().main.structureSpawnRates.veryCommon()) {
            return 5;
        } else if (options().main.structureSpawnRates.common()) {
            return 7;
        } else if (options().main.structureSpawnRates.normal() ||
                options().main.structureSpawnRates.rare()) {
            return 8;
        } else if (options().main.structureSpawnRates.ddefault()) {
            return 4;
        } else if (options().main.structureSpawnRates.veryRare()) {
            return 10;
        } else {
            return 0;
        }
    }

    public static int getSpeedrunnerWaterColor() {
        return 0x85C1E9;
    }

    public static int getSpeedrunnerWaterFogColor() {
        return 0x85C1E9;
    }

    public static int getMaximumAmountOfPiglinAllowedViaPiglinAwakener() {
        return options().advanced.piglinAwakenerPiglinCount;
    }

    public static float getBoatInLavaVelocityMultiplier() {
        return 0.95F;
    }

    public static float getSpeedrunnerBoatVelocityMultiplier() {
        return 1.035F;
    }

    public static float getBedBlockExplosionPower() {
        return DOOM_MODE ? 15.0F : 5.0F;
    }

    public static int getFireFromLavaTime() {
        return DOOM_MODE ? 15 : 7;
    }

    public static float getLavaDamageAmount() {
        return DOOM_MODE ? 4.0F : 2.0F;
    }

    public static int getPlayerBreathTime() {
        return options().advanced.higherBreathTime ? 8 : 4;
    }

    public static int getBlazeFireballCooldown() {
        return DOOM_MODE ? 60 : 180;
    }

    public static int getDolphinRange() {
        return 200;
    }

    public static int getEnderDragonFireballInstantDamageAmplifier() {
        return DOOM_MODE ? 1 : 0;
    }

    public static double getEnderDragonMaxHealth() {
        return DOOM_MODE ? 500.0D : 100.0D;
    }

    public static float getEnderDragonEndCrystalHealAmount() {
        return DOOM_MODE ? 1.7F : 0.1F;
    }

    public static float getEnderDragonDamageMultiplier() {
        return DOOM_MODE ? 12.0F : 3.0F;
    }

    public static float getEnderDragonEndCrystalDestroyedHealthAmount() {
        return DOOM_MODE ? 3.0F : 20.0F;
    }

    public static float getEnderDragonStayPerchedTime() {
        if (options().advanced.longerDragonPerchStayTime) {
            return DOOM_MODE ? 0.18F : 0.60F;
        } else {
            return 0.25F;
        }
    }

    public static float getEnderPearlDamageMultiplier() {
        return DOOM_MODE ? 5.0F : 2.0F;
    }

    public static int getGhastFireballCooldown() {
        return DOOM_MODE ? -5 : -40;
    }

    public static int getSlimeJumpTime() {
        return DOOM_MODE ? 20 : 100;
    }

    public static float getSlimeDamageMultiplier() {
        return DOOM_MODE ? 2.2F : 1.5F;
    }

    public static double getZombifiedPiglinRunawayDistance() {
        return options().advanced.decreasedZombifiedPiglinScareDistance ? 2.0D : 6.0D;
    }

    public static int getSilverfishCallForHelpDelay() {
        return DOOM_MODE ? 20 : 100;
    }

    public static int getFireballFireTime() {
        return DOOM_MODE ? 6 : 3;
    }

    public static float getFireballDamageMultiplier() {
        return DOOM_MODE ? 5.0F : 1.0F;
    }

    public static float getVexDecayDamageMultiplier() {
        return DOOM_MODE ? 100.0F : 1.0F;
    }

    public static double getWitherMaxHealth() {
        return DOOM_MODE ? 150.0 : 100.0;
    }

    public static int getWitherSkeletonWitherEffectDuration() {
        return DOOM_MODE ? 200 : 60;
    }

    public static int getStrongholdMinY() {
        return DOOM_MODE ? -48 : 27;
    }

    public static int getStrongholdMaxY() {
        int seaLevel = 63;
        return DOOM_MODE ? 0 : seaLevel;
    }

    public static float getEnderEyeChance() {
        return DOOM_MODE ? 0.99F : 0.6F;
    }

    public static int getPlainsTreeCount() {
        return 1;
    }
}