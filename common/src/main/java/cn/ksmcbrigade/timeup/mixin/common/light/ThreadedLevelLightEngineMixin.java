package cn.ksmcbrigade.timeup.mixin.common.light;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.server.level.ThreadedLevelLightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ThreadedLevelLightEngine.class)
public class ThreadedLevelLightEngineMixin {
    @Inject(method = {"runLightUpdates"},at = @At("HEAD"),cancellable = true)
    public void up(CallbackInfoReturnable<Integer> cir){
        if(CommonClass.timing) cir.setReturnValue(0);
    }

    @Inject(method = {"runUpdate","tryScheduleUpdate"},at = @At("HEAD"),cancellable = true)
    public void up(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
