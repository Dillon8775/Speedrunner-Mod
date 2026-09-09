package net.dillon.speedrunnermod.loot.context;

import net.dillon.speedrunnermod.loot.mc.LootTableData;
import net.dillon.speedrunnermod.loot.mc.chest.*;
import net.dillon.speedrunnermod.mixin.accessor.SimpleFabricLootTableSubProviderAccessor;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * All custom speedrunner mod chest loot tables.
 */
public class ModChestLootTables extends SimpleFabricLootTableSubProvider {

    public ModChestLootTables(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.CHEST);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context) {
        HolderLookup.Provider provider = ((SimpleFabricLootTableSubProviderAccessor)this).getRegistryLookupFuture().join();
        HolderGetter<Enchantment> enchantments = provider.lookupOrThrow(Registries.ENCHANTMENT);
        HolderGetter<Structure> structure = provider.lookupOrThrow(Registries.STRUCTURE);

        LootTableData data = new LootTableData(context, enchantments, structure);

        RuinedPortalLoot ruinedPortalLoot = new RuinedPortalLoot(data);
        ruinedPortalLoot.generateLoot();

        ShipwreckLoot shipwreckLoot = new ShipwreckLoot(data);
        shipwreckLoot.generateSupplyLoot();
        shipwreckLoot.generateTreasureLoot();

        SimpleDungeonLoot simpleDungeonLoot = new SimpleDungeonLoot(data);
        simpleDungeonLoot.generateLoot();

        StrongholdLoot strongholdLoot = new StrongholdLoot(data);
        strongholdLoot.generateCorridorLoot();
        strongholdLoot.generateCrossingLoot();
        strongholdLoot.generateLibraryLoot();

        UnderwaterRuinLoot underwaterRuinLoot = new UnderwaterRuinLoot(data);
        underwaterRuinLoot.generateBigLoot();
        underwaterRuinLoot.generateSmallLoot();

        WoodlandMansionLoot woodlandMansionLoot = new WoodlandMansionLoot(data);
        woodlandMansionLoot.generateLoot();
    }

    @Override
    public void run() {
    }
}