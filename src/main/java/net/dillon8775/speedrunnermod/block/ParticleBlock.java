package net.dillon8775.speedrunnermod.block;

import net.dillon8775.speedrunnermod.SpeedrunnerModClient;
import net.dillon8775.speedrunnermod.particle.ModParticleEffects;
import net.dillon8775.speedrunnermod.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ParticleBlock extends Block {

    protected ParticleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (SpeedrunnerModClient.clOptions().blockParticles && world.getBiomeKey(pos).get() == ModBiomes.SPEEDRUNNERS_WASTELAND_KEY) {
            ModParticleEffects.spawnParticles(world, pos);
        }
    }
}