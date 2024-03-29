package net.dillon8775.speedrunnermod.mixin.main.entity;

import net.dillon8775.speedrunnermod.SpeedrunnerMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.options;

@Mixin(value = {ArrowEntity.class, SpectralArrowEntity.class})
public abstract class ArrowEntitiesMixin extends PersistentProjectileEntity {

    public ArrowEntitiesMixin(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * Makes beds explode when hit with an arrow.
     */
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (options().main.arrowsDestroyBeds && !(world.getRegistryKey() == World.OVERWORLD) && blockHitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = blockHitResult.getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);

            if (blockState.getBlock().getDefaultState().isIn(BlockTags.BEDS)) {
                this.discard();
                world.removeBlock(blockPos, false);
                world.createExplosion(this, getX(), getY(), getZ(), SpeedrunnerMod.getBedBlockExplosionPower(), true, Explosion.DestructionType.DESTROY);
            }
        }
        super.onBlockHit(blockHitResult);
    }
}