package net.dillon.speedrunnermod.loot;

import net.dillon.speedrunnermod.loot.mc.PiglinBarteringLoot;
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

import static net.dillon.speedrunnermod.loot.ModBlockLoot.createLootTable;

/**
 * Stores a custom loot table for piglin bartering.
 */
public class ModPiglinBarterLootTables extends SimpleFabricLootTableSubProvider {
    public static final ResourceKey<LootTable> MC_PIGLIN_BARTERING = createLootTable("gameplay/mc_piglin_bartering");
    private final CompletableFuture<HolderLookup.Provider> registryLookupFuture;

    public ModPiglinBarterLootTables(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.PIGLIN_BARTER);
        this.registryLookupFuture = registryLookupFuture;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context) {
        HolderLookup.Provider provider = this.registryLookupFuture.join();
        HolderGetter<Enchantment> enchantments = provider.lookupOrThrow(Registries.ENCHANTMENT);

        PiglinBarteringLoot.generateLoot(context, enchantments);
    }

    @Override
    public void run() {
    }
}