package net.dillon.speedrunnermod.mixin.accessor;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Goal.class)
public interface GoalInvoker {
    @Invoker("getServerLevel")
    static ServerLevel getServerLevel(final Entity entity) {
        throw new AssertionError();
    }
    @Invoker("getServerLevel")
    static ServerLevel getServerLevel(final Level level) {
        throw new AssertionError();
    }
}