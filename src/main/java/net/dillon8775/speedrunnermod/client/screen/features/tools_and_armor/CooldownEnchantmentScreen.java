package net.dillon8775.speedrunnermod.client.screen.features.tools_and_armor;

import net.dillon8775.speedrunnermod.client.screen.features.AbstractFeatureScreen;
import net.dillon8775.speedrunnermod.client.screen.features.ScreenCategories;
import net.dillon8775.speedrunnermod.client.screen.features.ScreenType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class CooldownEnchantmentScreen extends AbstractFeatureScreen {

    public CooldownEnchantmentScreen(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("speedrunnermod.title.features.tools_and_armor.cooldown_enchantment").formatted(Formatting.AQUA), 5, true, false);
    }

    @Override
    protected @NotNull String linesKey() {
        return "cooldown_enchantment";
    }

    @Override
    protected Identifier getImage() {
        return new Identifier("speedrunnermod:textures/gui/screens/enchanted_book.png");
    }

    @Override
    protected int getImageWidth() {
        return 32;
    }

    @Override
    protected int getImageHeight() {
        return 28;
    }

    @Override
    protected Identifier getCraftingRecipeImage() {
        return null;
    }

    @Override
    protected @NotNull ScreenCategories getScreenCategory() {
        return ScreenCategories.TOOLS_AND_ARMOR;
    }

    @Override
    protected int getScreenLines() {
        return 2;
    }

    @Override
    protected @NotNull ScreenType getScreenType() {
        return ScreenType.NORMAL;
    }
}