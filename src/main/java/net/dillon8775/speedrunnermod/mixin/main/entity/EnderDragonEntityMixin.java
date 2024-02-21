package net.dillon8775.speedrunnermod.mixin.main.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.boss.dragon.phase.PhaseManager;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.DOOM_MODE;

@Mixin(value = EnderDragonEntity.class, priority = 999)
public abstract class EnderDragonEntityMixin extends MobEntity {
    @Shadow
    private int damageDuringSitting;
    @Shadow
    abstract boolean parentDamage(DamageSource source, float amount);
    @Shadow @Final
    private EnderDragonPart head;
    @Shadow @Final
    private PhaseManager phaseManager;

    public EnderDragonEntityMixin(EntityType<? extends EnderDragonEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyArg(method = "createEnderDragonAttributes", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;add(Lnet/minecraft/entity/attribute/EntityAttribute;D)Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;"), index = 1)
    private static double genericMaxHealth(double baseValue) {
        return DOOM_MODE ? 500.0D : 100.0D;
    }

    /**
     * Makes the ender dragon heal slower and less than normal, unless it's on {@code doom mode}.
     */
    @ModifyArg(method = "tickWithEndCrystals", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/boss/dragon/EnderDragonEntity;setHealth(F)V"))
    private float tickCrystals(float value) {
        return DOOM_MODE ? 1.7F : 0.1F;
    }

    /**
     * Makes the ender dragon do less damage.
     */
    @ModifyArg(method = "damageLivingEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float damageLivingEntities(float amount) {
        return DOOM_MODE ? 12.0F : 3.0F;
    }

    /**
     * Damages the ender dragon more when a crystal is destroyed.
     */
    @ModifyArg(method = "crystalDestroyed", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/boss/dragon/EnderDragonEntity;damagePart(Lnet/minecraft/entity/boss/dragon/EnderDragonPart;Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 2)
    private float crystalDestroyed(float amount) {
        return DOOM_MODE ? 3.0F : 20.0F;
    }

    /**
     * Allows the ender dragon to stay perched for a longer period of time.
     */
    @Overwrite
    public boolean damagePart(EnderDragonPart part, DamageSource source, float amount) {
        if (this.phaseManager.getCurrent().getType() == PhaseType.DYING) {
            return false;
        } else {
            amount = this.phaseManager.getCurrent().modifyDamageTaken(source, amount);
            if (part != this.head) {
                amount = amount / 4.0F + Math.min(amount, 1.0F);
            }

            if (amount < 0.01F) {
                return false;
            } else {
                if (source.getAttacker() instanceof PlayerEntity || source.isExplosive()) {
                    float f = this.getHealth();
                    this.parentDamage(source, amount);
                    if (this.isDead() && !this.phaseManager.getCurrent().isSittingOrHovering()) {
                        this.setHealth(1.0F);
                        this.phaseManager.setPhase(PhaseType.DYING);
                    }

                    if (this.phaseManager.getCurrent().isSittingOrHovering()) {
                        this.damageDuringSitting = (int)((float)this.damageDuringSitting + (f - this.getHealth()));
                        final float g = DOOM_MODE ? 0.18F : 0.60F;
                        if ((float)this.damageDuringSitting > g * this.getMaxHealth()) {
                            this.damageDuringSitting = 0;
                            this.phaseManager.setPhase(PhaseType.TAKEOFF);
                        }
                    }
                }

                return true;
            }
        }
    }
}