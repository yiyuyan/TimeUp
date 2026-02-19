package cn.ksmcbrigade.timeup.mixin.client;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public class CameraMixin {
    @Inject(method = "getPartialTickTime",at = @At("HEAD"),cancellable = true)
    public void partialTick(CallbackInfoReturnable<Float> cir){
        if(CommonClass.timing) cir.setReturnValue(0F);
    }
}
