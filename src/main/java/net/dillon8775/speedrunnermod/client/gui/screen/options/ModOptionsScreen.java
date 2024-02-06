package net.dillon8775.speedrunnermod.client.gui.screen.options;

import net.dillon8775.speedrunnermod.client.gui.screen.ResetOptionsConfirmScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

public class ModOptionsScreen extends GameOptionsScreen {
    private final Screen parent;

    public ModOptionsScreen(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("speedrunnermod.title.options"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int leftSide = this.width / 2 - 155;
        int rightSide = leftSide + 160;
        int height = this.height / 6 - 12;

        this.addDrawableChild(new ButtonWidget(leftSide, height, 150, 20, new TranslatableText("speedrunnermod.menu.options.main"), (buttonWidget) -> {
            this.client.setScreen(new MainOptionsScreen(this.parent, MinecraftClient.getInstance().options));
        }));
        this.addDrawableChild(new ButtonWidget(rightSide, height, 150, 20, new TranslatableText("speedrunnermod.menu.options.fast_world_creation"), (buttonWidget) -> {
            this.client.setScreen(new FastWorldCreationOptionsScreen(this.parent, MinecraftClient.getInstance().options));
        }));

        height += 24;
        this.addDrawableChild(new ButtonWidget(leftSide, height, 150, 20, new TranslatableText("speedrunnermod.menu.options.advanced"), (buttonWidget) -> {
            this.client.setScreen(new AdvancedOptionsScreen(this.parent, MinecraftClient.getInstance().options));
        }));
        this.addDrawableChild(new ButtonWidget(rightSide, height, 150, 20, new TranslatableText("speedrunnermod.menu.options.reset"), (buttonWidget) -> {
            this.client.setScreen(new ResetOptionsConfirmScreen(this.parent, MinecraftClient.getInstance().options));
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 29, 200, 20, ScreenTexts.DONE, (button) -> {
            this.client.setScreen(this.parent);
        }));
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}