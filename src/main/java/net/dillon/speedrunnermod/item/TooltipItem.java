package net.dillon.speedrunnermod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

/**
 * A basic speedrunner item with a helpful tooltip attatched to it.
 */
public class TooltipItem extends Item {
    private final Component[] tooltips;

    public TooltipItem(Properties properties, Component... tooltips) {
        super(properties);
        this.tooltips = tooltips;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> textConsumer, TooltipFlag type) {
        for (Component tooltip : tooltips) {
            SpeedrunnerItem.addWrappedTooltip(textConsumer, tooltip);
        }
        super.appendHoverText(stack, context, displayComponent, textConsumer, type);
    }
}