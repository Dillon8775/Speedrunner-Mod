package net.dillon.speedrunnermod.loot.providers;

import net.dillon.speedrunnermod.loot.ModBlockLoot;
import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static net.dillon.speedrunnermod.loot.data.GeneratableLootTable.createLootTable;

public class ModBlockLootTables extends SimpleModLootTableSubProvider {
    public static final ResourceKey<LootTable> DOOM_BLOCK_LOOT = createLootTable("world/block/doom_block");

    public ModBlockLootTables(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.BLOCK);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        LootTableData data = this.getLootTableData(output);

        new ModBlockLoot.DoomBlockLoot(data).generateLoot();
    }
}