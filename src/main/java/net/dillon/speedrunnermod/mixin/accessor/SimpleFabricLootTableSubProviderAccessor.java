package net.dillon.speedrunnermod.mixin.accessor;

import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderLookup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.concurrent.CompletableFuture;

@Mixin(SimpleFabricLootTableSubProvider.class)
public interface SimpleFabricLootTableSubProviderAccessor {
    @Accessor("registryLookupFuture")
    CompletableFuture<HolderLookup.Provider> getRegistryLookupFuture();
}