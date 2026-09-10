package net.dillon.speedrunnermod.loot.providers;

import net.dillon.speedrunnermod.loot.data.LootTableData;
import net.dillon.speedrunnermod.loot.vanilla.container.*;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModChestLootTables extends SimpleModLootTableSubProvider {

    public ModChestLootTables(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.CHEST);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> context) {
        LootTableData data = this.getLootTableData(context);

        new AbandonedCampLoot(data).generateLoot();
        new AbandonedMineshaftLoot(data).generateLoot();
        new AncientCityLoot(data).generateLoot();
        new BastionLoot(data).generateLoot();
        new BuriedTreasureLoot(data).generateLoot();
        new DesertPyramidLoot(data).generateLoot();
        new EndCityLoot(data).generateLoot();
        new IglooLoot(data).generateLoot();
        new JungleTempleLoot(data).generateLoot();
        new NetherFortressLoot(data).generateLoot();
        new PillagerOutpostLoot(data).generateLoot();
        new RuinedPortalLoot(data).generateLoot();
        new ShipwreckLoot(data).generateLoot();
        new SimpleDungeonLoot(data).generateLoot();
        new StrongholdLoot(data).generateLoot();
        new TrialChamberLoot(data).generateLoot();
        new UnderwaterRuinLoot(data).generateLoot();
        new VillageLoot(data).generateLoot();
        new WoodlandMansionLoot(data).generateLoot();
    }
}