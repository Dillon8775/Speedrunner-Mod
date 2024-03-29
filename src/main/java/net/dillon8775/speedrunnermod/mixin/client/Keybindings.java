package net.dillon8775.speedrunnermod.mixin.client;

import net.dillon8775.speedrunnermod.client.keybind.ModKeybindings;
import net.dillon8775.speedrunnermod.option.ModOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.SaveLevelScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.debug;
import static net.dillon8775.speedrunnermod.SpeedrunnerMod.options;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public abstract class Keybindings {
    @Shadow @Final
    public InGameHud inGameHud;
    @Shadow
    public ClientWorld world;
    @Shadow
    public abstract void disconnect(Screen screen);
    @Shadow
    public abstract void setScreen(@Nullable Screen screen);
    @Shadow
    public abstract boolean isInSingleplayer();

    /**
     * Applies the {@code speedrunner mod keybinds} to the game.
     */
    @Inject(at = @At("TAIL"), method = "handleInputEvents")
    private void handleInputEvents(CallbackInfo info) {
        while (ModKeybindings.resetKey.wasPressed()) {
            if (this.isInSingleplayer()) {
                if (options().client.fastWorldCreation) {
                    if (this.inGameHud != null) {
                        this.inGameHud.getChatHud().clear(false);
                    }
                    assert this.world != null;
                    this.world.disconnect();
                    this.disconnect(new SaveLevelScreen(new TranslatableText("menu.savingLevel")));
                    this.setScreen(CreateWorldScreen.create(null));
                } else {
                    debugWarnSpeedrunnerMod("\"Fast World Creation\" is OFF, please enable to use this feature.");
                }
            } else {
                debugWarnSpeedrunnerMod("You must be in singleplayer to create new worlds.");
            }
        }

        while (ModKeybindings.fogKey.wasPressed()) {
            options().client.fog = !options().client.fog;
            ModOptions.saveConfig();
            MinecraftClient.getInstance().worldRenderer.reload();
            debugWarnSpeedrunnerMod(options().client.fog ? "speedrunnermod.toggle_fog.on" : "speedrunnermod.toggle_fog.off");
        }

        while (ModKeybindings.hitboxesKey.wasPressed()) {
            boolean bl = !MinecraftClient.getInstance().getEntityRenderDispatcher().shouldRenderHitboxes();
            String hitboxes = bl ? "ON" : "OFF";
            MinecraftClient.getInstance().getEntityRenderDispatcher().setRenderHitboxes(bl);
            debugWarn(bl ? "debug.show_hitboxes.on" : "debug.show_hitboxes.off");
            debug("Toggled hitboxes " + hitboxes);
        }

        while (ModKeybindings.chunkBordersKey.wasPressed()) {
            boolean bl = MinecraftClient.getInstance().debugRenderer.toggleShowChunkBorder();
            String chunkBorders = bl ? "ON" : "OFF";
            debugWarn(bl ? "debug.chunk_boundaries.on" : "debug.chunk_boundaries.off");
            debug("Toggled chunk borders " + chunkBorders);
        }
    }

    @Unique
    private void debugWarn(String string, Object... objects) {
        this.inGameHud.getChatHud().addMessage((new LiteralText("")).append((new TranslatableText("debug.prefix")).formatted(Formatting.YELLOW, Formatting.BOLD)).append(" ").append(new TranslatableText(string, objects)));
    }

    @Unique
    private void debugWarnSpeedrunnerMod(String string, Object... objects) {
        this.inGameHud.getChatHud().addMessage((new LiteralText("")).append((new TranslatableText("speedrunnermod.debug.prefix")).formatted(Formatting.AQUA, Formatting.BOLD)).append(" ").append(new TranslatableText(string, objects)));
    }
}