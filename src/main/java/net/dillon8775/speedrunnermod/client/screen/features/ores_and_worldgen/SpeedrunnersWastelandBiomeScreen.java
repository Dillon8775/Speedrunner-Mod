package net.dillon8775.speedrunnermod.client.screen.features.ores_and_worldgen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dillon8775.speedrunnermod.client.screen.features.AbstractFeatureScreen;
import net.dillon8775.speedrunnermod.client.screen.features.ScreenCategories;
import net.dillon8775.speedrunnermod.client.screen.features.ScreenType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class SpeedrunnersWastelandBiomeScreen extends AbstractFeatureScreen {

    public SpeedrunnersWastelandBiomeScreen(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("speedrunnermod.title.features.ores_and_worldgen.speedrunners_wasteland").formatted(Formatting.AQUA), 1, false, false);
    }

    @Override
    protected @NotNull String linesKey() {
        return "speedrunners_wasteland";
    }

    @Override
    protected void renderCustomImage(MatrixStack matrices) {
        RenderSystem.setShaderTexture(0, new Identifier("speedrunnermod:textures/gui/screens/speedrunners_wasteland_biome.png"));
        drawTexture(matrices, this.width / 2, 170, 0.0F, 0.0F, this.getImageWidth(), this.getImageHeight(), this.getImageWidth(), this.getImageHeight());
    }

    @Override
    protected int getButtonsWidth() {
        return this.width / 2 - 175;
    }

    @Override
    protected @NotNull Identifier getImage() {
        return null;
    }

    @Override
    protected int getImageWidth() {
        return 240;
    }

    @Override
    protected int getImageHeight() {
        return 135;
    }

    @Override
    protected @NotNull Identifier getCraftingRecipeImage() {
        return null;
    }

    @Override
    protected @NotNull ScreenCategories getScreenCategory() {
        return ScreenCategories.ORES_AND_WORLDGEN;
    }

    @Override
    protected int getScreenLines() {
        return 4;
    }

    @Override
    protected @NotNull ScreenType getScreenType() {
        return ScreenType.STARTER;
    }
}