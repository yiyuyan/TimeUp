package cn.ksmcbrigade.timeup.mixin.common;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

@Mixin(Level.class)
public class LevelMixin {
    @Inject(method = "tickBlockEntities",at = @At("HEAD"),cancellable = true)
    public void noTick(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }

    @Inject(method = "guardEntityTick",at = @At("HEAD"),cancellable = true)
    public <T extends Entity> void noTick(Consumer<T> pConsumerEntity, T pEntity, CallbackInfo ci){
        if(CommonClass.timing && !(pEntity instanceof Player)) ci.cancel();
    }

    @Inject(method = "shouldTickBlocksAt(J)Z",at = @At("HEAD"),cancellable = true)
    public <T extends Entity> void noTickBL(CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(false);
    }

    @Inject(method = "shouldTickBlocksAt(Lnet/minecraft/core/BlockPos;)Z",at = @At("HEAD"),cancellable = true)
    public <T extends Entity> void noTickB(CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(false);
    }
}
