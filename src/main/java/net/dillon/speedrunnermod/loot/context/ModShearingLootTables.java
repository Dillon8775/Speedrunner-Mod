package net.dillon.speedrunnermod.loot.context;

import net.dillon.speedrunnermod.loot.mc.shear.SheepShearingLoot;
import net.dillon.speedrunnermod.mixin.accessor.SimpleFabricLootTableSubProviderAccessor;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * All custom speedrunner mod shearing loot tables.
 */
public class ModShearingLootTables extends SimpleFabricLootTableSubProvider {

    public ModShearingLootTables(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.SHEARING);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context) {
        HolderLookup.Provider provider = ((SimpleFabricLootTableSubProviderAccessor)this).getRegistryLookupFuture().join();
        HolderGetter<LootTable> lootTables = provider.lookupOrThrow(Registries.LOOT_TABLE);

        SheepShearingLoot.generateLoot(context, lootTables);
    }

    @Override
    public void run() {
    }
}