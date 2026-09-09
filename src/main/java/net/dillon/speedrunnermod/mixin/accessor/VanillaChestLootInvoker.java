package net.dillon.speedrunnermod.mixin.accessor;

import net.minecraft.data.loot.packs.VanillaChestLoot;
import net.minecraft.world.level.storage.loot.functions.FilteredFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(VanillaChestLoot.class)
public interface VanillaChestLootInvoker {
    @Invoker("discardIfNotValidMap")
    static FilteredFunction.Builder discardIfNotValidMap() {
        throw new AssertionError();
    }
}