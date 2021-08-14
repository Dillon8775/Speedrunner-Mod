package com.dilloney.speedrunnermod.mixins.entity.passive;

import com.dilloney.speedrunnermod.SpeedrunnerMod;
import com.dilloney.speedrunnermod.tag.ModItemTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin extends AnimalEntity implements Shearable {

    protected SheepEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow @Final static Map<DyeColor, ItemConvertible> DROPS;
    @Shadow abstract void setSheared(boolean sheared);
    @Shadow abstract DyeColor getColor();

    @Overwrite
    public void sheared(SoundCategory shearedSoundCategory) {
        if (SpeedrunnerMod.OPTIONS.modifiedLootTables) {
            this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
            this.setSheared(true);
            int i = 6 + this.random.nextInt(4);

            for(int j = 0; j < i; ++j) {
                ItemEntity itemEntity = this.dropItem((ItemConvertible)DROPS.get(this.getColor()), 1);
                if (itemEntity != null) {
                    itemEntity.setVelocity(itemEntity.getVelocity().add((double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F), (double)(this.random.nextFloat() * 0.05F), (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
                }
            }
        } else {
            this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
            this.setSheared(true);
            int i = 1 + this.random.nextInt(3);

            for(int j = 0; j < i; ++j) {
                ItemEntity itemEntity = this.dropItem((ItemConvertible)DROPS.get(this.getColor()), 1);
                if (itemEntity != null) {
                    itemEntity.setVelocity(itemEntity.getVelocity().add((double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F), (double)(this.random.nextFloat() * 0.05F), (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
                }
            }
        }
    }

    @Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean makeSpeedrunnerShearsWorkOnSheep(ItemStack stack, Item isOfItem) {
        return stack.isIn(ModItemTags.SHEARS);
    }
}