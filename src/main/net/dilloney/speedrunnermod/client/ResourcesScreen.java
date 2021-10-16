package net.dilloney.speedrunnermod.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ConfirmChatLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

@Environment(EnvType.CLIENT)
class ResourcesScreen extends Screen {
    private final Screen parent;
    private ButtonListWidget list;

    protected ResourcesScreen(Screen parent) {
        super(new TranslatableText("speedrunnermod.resources"));
        this.parent = parent;
    }

    protected void init() {
        this.list = new ButtonListWidget(this.client, this.width, this.height, 32, this.height - 32, 25);
        this.addButton(new ButtonWidget(this.width / 2 - 155, 40, 150, 20, new TranslatableText("speedrunnermod.mod_showcase_video"), (buttonWidget) -> {
            this.client.openScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open("https://www.youtube.com/watch?v=6MmH5B3zciA");
                }

                this.client.openScreen(this);
            }, "https://www.youtube.com/watch?v=6MmH5B3zciA", false));
        }, (buttonWidget, matrixStack, i, j) -> {
            this.renderTooltip(matrixStack, new TranslatableText("speedrunnermod.mod_showcase_video.tooltip"), i, j);
        }));
        ButtonWidget timer_mod = this.addButton(new ButtonWidget(this.width / 2 + 5, 40, 150, 20, new TranslatableText("speedrunnermod.timer_mod"), (buttonWidget) -> {
            this.client.openScreen(this.parent);
        }, (buttonWidget, matrixStack, i, j) -> {
            this.renderTooltip(matrixStack, new TranslatableText("speedrunnermod.timer_mod.tooltip"), i, j);
        }));
        timer_mod.active = false;
        this.addButton(new ButtonWidget(this.width / 2 - 155, 65, 150, 20, new TranslatableText("speedrunnermod.sodium"), (buttonWidget) -> {
            this.client.openScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open("https://www.curseforge.com/minecraft/mc-mods/sodium/files");
                }

                this.client.openScreen(this);
            }, "https://www.curseforge.com/minecraft/mc-mods/sodium", false));
        }));
        this.addButton(new ButtonWidget(this.width / 2 + 5, 65, 150, 20, new TranslatableText("speedrunnermod.lithium"), (buttonWidget) -> {
            this.client.openScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open("https://www.curseforge.com/minecraft/mc-mods/lithium");
                }

                this.client.openScreen(this);
            }, "https://www.curseforge.com/minecraft/mc-mods/lithium", false));
        }));
        this.addButton(new ButtonWidget(this.width / 2 - 155, 90, 150, 20, new TranslatableText("speedrunnermod.phosphor"), (buttonWidget) -> {
            this.client.openScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open("https://www.curseforge.com/minecraft/mc-mods/phosphor");
                }

                this.client.openScreen(this);
            }, "https://www.curseforge.com/minecraft/mc-mods/phosphor", false));
        }));
        this.addButton(new ButtonWidget(this.width / 2 - 100, this.height - 27, 200, 20, ScreenTexts.DONE, (button) -> {
            this.client.openScreen(this.parent);
        }));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.list.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 12, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}