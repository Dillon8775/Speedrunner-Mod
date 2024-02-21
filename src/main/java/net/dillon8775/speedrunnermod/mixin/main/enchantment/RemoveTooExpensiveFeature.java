package net.dillon8775.speedrunnermod.mixin.main.enchantment;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.Property;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreenHandler.class)
public abstract class RemoveTooExpensiveFeature {
    @Shadow
    public abstract int getLevelCost();
    @Shadow @Final
    private Property levelCost;

    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40))
    private int mixinLimitInt(int i) {
        if (SpeedrunnerMod.options().betterAnvil) {
            return Integer.MAX_VALUE;
        } else {
            return 40;
        }
    }

    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 39))
    private int mixinMaxInt(int i) {
        if (SpeedrunnerMod.options().betterAnvil) {
            return Integer.MAX_VALUE - 1;
        } else {
            return 39;
        }
    }

    @Inject(method = "updateResult", at = @At("TAIL"))
    private void setLevelCostIfTooHigh(CallbackInfo ci) {
        if (SpeedrunnerMod.options().anvilCostLimit != 50) {
            this.levelCost.set(SpeedrunnerMod.options().anvilCostLimit);
        }
    }
}