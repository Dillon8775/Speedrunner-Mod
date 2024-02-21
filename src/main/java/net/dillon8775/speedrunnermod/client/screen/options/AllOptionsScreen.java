package net.dillon8775.speedrunnermod.client.screen.options;

import net.dillon8775.speedrunnermod.client.screen.RestartRequiredScreen;
import net.dillon8775.speedrunnermod.client.util.ModTexts;
import net.dillon8775.speedrunnermod.option.ClientModOptions;
import net.dillon8775.speedrunnermod.option.ModListOptions;
import net.dillon8775.speedrunnermod.option.ModOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Option;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;

import java.util.List;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.info;

@Environment(EnvType.CLIENT)
public class AllOptionsScreen extends GameOptionsScreen {
    private static final Option[] OPTIONS;
    private ButtonListWidget list;

    public AllOptionsScreen(Screen parent, GameOptions options) {
        super(parent, options, ModTexts.TITLE_OPTIONS_ALL);
    }

    @Override
    protected void init() {
        this.list = new ButtonListWidget(this.client, this.width, this.height, 32, this.height - 32, 25);
        this.list.addSingleOptionEntry(ModListOptions.STRUCTURE_SPAWN_RATE);
        this.list.addSingleOptionEntry(ModListOptions.FASTER_BLOCK_BREAKING);
        this.list.addSingleOptionEntry(ModListOptions.GENERATE_SPEEDRUNNER_TREES);
        this.list.addSingleOptionEntry(ModListOptions.MOB_SPAWNER_MINIMUM_SPAWN_DURATION);
        this.list.addSingleOptionEntry(ModListOptions.MOB_SPAWNER_MAXIMUM_SPAWN_DURATION);
        this.list.addSingleOptionEntry(ModListOptions.PANORAMA);
        this.list.addAll(OPTIONS);
        this.addSelectableChild(this.list);
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 29, 200, 20, ModTexts.SAVE, (button) -> {
            this.onClose();
        }));
    }

    @Override
    public void onClose() {
        ModOptions.saveConfig();
        ClientModOptions.saveClientConfig();
        if (RestartRequiredScreen.needsRestart()) {
            this.client.setScreen(new RestartRequiredScreen(this.parent, MinecraftClient.getInstance().options));
        } else {
            info("Saved changes");
            this.client.setScreen(new ModOptionsScreen(this.parent, MinecraftClient.getInstance().options));
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.list.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 12, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
        List<OrderedText> list = getHoveredButtonTooltip(this.list, mouseX, mouseY);
        if (list != null) {
            this.renderOrderedTooltip(matrices, list, mouseX, mouseY);
        }
    }

    static {
        OPTIONS = new Option[]{
                ModListOptions.BETTER_BIOMES,
                ModListOptions.ICARUS_MODE,

                ModListOptions.FOG,
                ModListOptions.INFINITY_PEARL_MODE,

                ModListOptions.ITEM_TOOLTIPS,
                ModListOptions.ITEM_MESSAGES,

                ModListOptions.DRAGON_PERCH_TIME,
                ModListOptions.KILL_GHAST_ON_FIREBALL,

                ModListOptions.DOOM_MODE,
                ModListOptions.FIREPROOF_ITEMS,

                ModListOptions.FAST_WORLD_CREATION,
                ModListOptions.GAMEMODE,

                ModListOptions.DIFFICULTY,
                ModListOptions.ALLOW_CHEATS,

                ModListOptions.CUSTOM_BIOMES,
                ModListOptions.COMMON_ORES,

                ModListOptions.STRONGHOLD_DISTANCE,
                ModListOptions.STRONGHOLD_SPREAD,

                ModListOptions.STRONGHOLD_COUNT,
                ModListOptions.STRONGHOLD_PORTAL_ROOM_COUNT,

                ModListOptions.STRONGHOLD_LIBRARY_COUNT,
                ModListOptions.BLOCK_PARTICLES,

                ModListOptions.MOD_BUTTON_TYPE,
                ModListOptions.SOCIAL_BUTTONS,

                ModListOptions.LAVA_BOATS,
                ModListOptions.NETHER_WATER,

                ModListOptions.FALL_DAMAGE,
                ModListOptions.BETTER_FOODS,

                ModListOptions.NETHER_PORTAL_COOLDOWN,
                ModListOptions.MOB_SPAWNING_RATE,

                ModListOptions.GLOBAL_NETHER_PORTALS,
                ModListOptions.HIGHER_BREATH_TIME,

                ModListOptions.BETTER_ANVIL,
                ModListOptions.ANVIL_COST_LIMIT,

                ModListOptions.BETTER_VILLAGER_TRADES,
                ModListOptions.HIGHER_ENCHANTMENT_LEVELS,

                Option.GAMMA
        };
    }
}