package net.dillon.speedrunnermod.entity.goliath;

import net.dillon.speedrunnermod.loot.ModFloatProviders;
import net.dillon.speedrunnermod.loot.ModIntProviders;
import net.dillon.speedrunnermod.mixin.accessor.GoalInvoker;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static net.dillon.speedrunnermod.option.ModCommonOptions.doomOrDefaultUnsafeFloat;
import static net.dillon.speedrunnermod.option.ModCommonOptions.doomOrDefaultUnsafeInt;

/**
 * A minion of {@link GoliathBase}.
 */
public interface MinionBase {
    void setFireballChargeTime(int time);
    int getFireballChargeTime();
    void setGoliathMinion(boolean value);
    boolean isGoliathMinion();

    /**
     * @return a zombie's fireball.
     */
    static ItemStack zombiesFireball(Item item) {
        ItemStack zombieFireball = new ItemStack(item);
        zombieFireball.set(DataComponents.ITEM_NAME, Component.translatable("item.minecraft.fire_charge.zombie"));
        return zombieFireball;
    }

    /**
     * @return the cooldown for a fireball.
     */
    static int fireballChargeTime(Zombie zombie) {
        ServerLevel serverLevel = GoalInvoker.getServerLevel(zombie);
        return doomOrDefaultUnsafeInt(ModIntProviders.ZOMBIE_FIREBALL_CHARGE_SPEED_ON_DOOM_MODE, ModIntProviders.ZOMBIE_FIREBALL_CHARGE_SPEED_DEFAULT, serverLevel);
    }

    /**
     * @return the chance for a isZombie to spawn with a fireball.
     */
    static float spawnWithFireballChance(Zombie zombie) {
        return doomOrDefaultUnsafeFloat(ModFloatProviders.ZOMBIE_SPAWN_WITH_FIREBALL_CHANCE_ON_DOOM_MODE, ModFloatProviders.ZOMBIE_SPAWN_WITH_FIREBALL_CHANCE_DEFAULT, GoalInvoker.getServerLevel(zombie));
    }
}