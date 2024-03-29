package net.dillon8775.speedrunnermod.mixin.client.fix;

import net.dillon8775.speedrunnermod.tag.ModBlockTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.screen.SmithingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(SmithingScreenHandler.class)
public class SmithingScreenHandlerMixin {

    /**
     * Fixes the {@code Speedrunner's Workbench} GUI screen not working correctly.
     */
    @Inject(method = "canUse", at = @At("RETURN"), cancellable = true)
    private void canUseSpeedrunnersWorkbench(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(state.isIn(ModBlockTags.SMITHING_TABLES));
    }
}