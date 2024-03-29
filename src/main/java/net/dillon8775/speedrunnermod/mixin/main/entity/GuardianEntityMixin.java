package net.dillon8775.speedrunnermod.mixin.main.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.dillon8775.speedrunnermod.SpeedrunnerMod.DOOM_MODE;

@Mixin(GuardianEntity.class)
public class GuardianEntityMixin extends HostileEntity {

    public GuardianEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * Increases the experience dropped upon death.
     */
    @Override
    public int getXpToDrop(PlayerEntity player) {
        if (player != null) {
            this.experiencePoints = 10 + EnchantmentHelper.getLooting(player) * 36;
        }
        return super.getXpToDrop(player);
    }

    /**
     * Modifies the guardian's attributes.
     */
    @Overwrite
    public static DefaultAttributeContainer.Builder createGuardianAttributes() {
        final double genericAttackDamage = DOOM_MODE ? 7.0D : 3.0D;
        final double genericMovementSpeed = 0.5D;
        final double genericFollowRange = DOOM_MODE ? 24.0D : 8.0;
        final double genericMaxHealth = DOOM_MODE ? 35.0D : 15.0D;
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, genericAttackDamage)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, genericMovementSpeed)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, genericFollowRange)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, genericMaxHealth);
    }
}