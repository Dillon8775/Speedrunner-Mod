package net.dillon.speedrunnermod.loot.context;

import net.dillon.speedrunnermod.loot.mc.barter.PiglinBarteringLoot;
import net.dillon.speedrunnermod.mixin.accessor.SimpleFabricLootTableSubProviderAccessor;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * Stores a custom loot table for piglin bartering.
 */
public class ModPiglinBarterLootTables extends SimpleFabricLootTableSubProvider {

    public ModPiglinBarterLootTables(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.PIGLIN_BARTER);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context) {
        HolderLookup.Provider provider = ((SimpleFabricLootTableSubProviderAccessor)this).getRegistryLookupFuture().join();
        HolderGetter<Enchantment> enchantments = provider.lookupOrThrow(Registries.ENCHANTMENT);

        PiglinBarteringLoot.generateLoot(context, enchantments);
    }

    @Override
    public void run() {
    }
}