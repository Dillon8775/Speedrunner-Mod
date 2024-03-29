package net.dillon8775.speedrunnermod.client.screen.features;

import net.dillon8775.speedrunnermod.client.screen.AbstractModScreen;
import net.dillon8775.speedrunnermod.client.screen.features.doom_mode.*;
import net.dillon8775.speedrunnermod.client.util.ModTexts;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

@Environment(EnvType.CLIENT)
public class DoomModeScreen extends AbstractModScreen {

    public DoomModeScreen(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("speedrunnermod.title.features.doom_mode"));
    }

    @Override
    protected void init() {
        int height = this.getButtonsHeight();

        this.addDrawableChild(new ButtonWidget(this.getButtonsLeftSide(), height, this.getButtonsWidth(), 20, ModTexts.featureTitleText(ScreenCategories.DOOM_MODE, "basics").formatted(Formatting.RED), (button) -> {
            this.client.setScreen(new BasicsScreen(this.parent, this.options));
        }));
        this.addDrawableChild(new ButtonWidget(this.getButtonsRightSide(), height, this.getButtonsWidth(), 20, ModTexts.featureTitleText(ScreenCategories.DOOM_MODE, "bosses").formatted(Formatting.LIGHT_PURPLE), (button) -> {
            this.client.setScreen(new BossesScreen(this.parent, this.options));
        }));

        height += 24;
        this.addDrawableChild(new ButtonWidget(this.getButtonsLeftSide(), height, this.getButtonsWidth(), 20, ModTexts.featureTitleText(ScreenCategories.DOOM_MODE, "giant").formatted(Formatting.GREEN).formatted(Formatting.BOLD), (button) -> {
            this.client.setScreen(new GiantScreen(this.parent, this.options));
        }));
        this.addDrawableChild(new ButtonWidget(this.getButtonsRightSide(), height, this.getButtonsWidth(), 20, ModTexts.featureTitleText(ScreenCategories.DOOM_MODE, "doom_blocks").formatted(Formatting.RED), (button) -> {
            this.client.setScreen(new DoomBlocksScreen(this.parent, this.options));
        }));

        height += 24;
        this.addDrawableChild(new ButtonWidget(this.getButtonsLeftSide(), height, this.getButtonsWidth(), 20, ModTexts.featureTitleText(ScreenCategories.DOOM_MODE, "other_things_to_know"), (button) -> {
            this.client.setScreen(new OtherThingsToKnowScreen(this.parent, this.options));
        }));

        this.addDrawableChild(new ButtonWidget(this.getButtonsMiddle(), this.getDoneButtonsHeight(), 200, 20, ScreenTexts.DONE, (button) -> {
            this.close();
        }));
    }

    @Override
    public void close() {
        this.client.setScreen(new FeaturesScreen(this.parent, this.options));
    }

    @Override
    protected int columns() {
        return 2;
    }

    @Override
    protected boolean shouldRenderVersionText() {
        return false;
    }

    @Override
    protected boolean isOptionsScreen() {
        return false;
    }

    @Override
    protected boolean shouldRenderTitleText() {
        return true;
    }
}