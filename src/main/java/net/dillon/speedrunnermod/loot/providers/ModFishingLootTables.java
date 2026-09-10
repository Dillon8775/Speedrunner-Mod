package net.dillon.speedrunnermod.loot.providers;

import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.dillon.speedrunnermod.loot.vanilla.fishing.FishingLoot;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModFishingLootTables extends SimpleModLootTableSubProvider {

    public ModFishingLootTables(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.FISHING);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context) {
        LootTableData data = this.getLootTableData(context);

        new FishingLoot(data).generateLoot();
    }
}