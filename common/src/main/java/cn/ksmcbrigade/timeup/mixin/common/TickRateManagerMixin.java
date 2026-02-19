package cn.ksmcbrigade.timeup.mixin.common;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.TickRateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TickRateManager.class)
public class TickRateManagerMixin {
    @Inject(method = "isEntityFrozen",at = @At("HEAD"),cancellable = true)
    public void frozen(Entity pEntity, CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing && !(pEntity instanceof Player)) cir.setReturnValue(true);
    }

    @Inject(method = "isSteppingForward",at = @At("HEAD"),cancellable = true)
    public void frozen(CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(false);
    }

    @Inject(method = "tick",at = @At("HEAD"),cancellable = true)
    public void frozen(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }

    @Inject(method = "isFrozen",at = @At("HEAD"),cancellable = true)
    public void freezing(CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(true);
    }
}
