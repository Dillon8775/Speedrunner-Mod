package net.dillon.speedrunnermod.loot.providers;

import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.dillon.speedrunnermod.mixin.accessor.SimpleFabricLootTableSubProviderAccessor;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.context.ContextKeySet;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public abstract class SimpleModLootTableSubProvider extends SimpleFabricLootTableSubProvider {
    protected final HolderLookup.Provider provider;
    protected final HolderGetter<Enchantment> enchantments;
    protected final HolderGetter<Structure> structures;
    protected final HolderGetter<Potion> potions;

    public SimpleModLootTableSubProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, ContextKeySet contextParamSet) {
        super(output, registryLookupFuture, contextParamSet);
        this.provider = ((SimpleFabricLootTableSubProviderAccessor)this).getRegistryLookupFuture().join();
        this.enchantments = this.provider.lookupOrThrow(Registries.ENCHANTMENT);
        this.structures = this.provider.lookupOrThrow(Registries.STRUCTURE);
        this.potions = this.provider.lookupOrThrow(Registries.POTION);
    }

    protected LootTableData getLootTableData(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context) {
        return new LootTableData(context, this.enchantments, this.structures, this.potions);
    }

    @Override
    public void run() {
    }
}