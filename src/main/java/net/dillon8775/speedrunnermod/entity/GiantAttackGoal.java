package net.dillon8775.speedrunnermod.entity;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.GiantEntity;

/**
 * Used in {@link net.dillon8775.speedrunnermod.mixin.main.entity.giant.GiantEntityMixin}
 */
public class GiantAttackGoal extends MeleeAttackGoal {
    private final GiantEntity giant;
    private int ticks;

    public GiantAttackGoal(GiantEntity giant, double speed, boolean pauseWhenMobIdle) {
        super(giant, speed, pauseWhenMobIdle);
        this.giant = giant;
    }

    public void start() {
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.giant.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        this.giant.setAttacking(this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2);
    }
}