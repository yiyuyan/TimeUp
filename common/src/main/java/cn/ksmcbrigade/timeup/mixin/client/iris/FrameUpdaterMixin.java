package cn.ksmcbrigade.timeup.mixin.client.iris;

import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.uniforms.FrameUpdateNotifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FrameUpdateNotifier.class,remap = false)
public class FrameUpdaterMixin {
    @Inject(method = "onNewFrame",at = @At("HEAD"),cancellable = true)
    public void no_u(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();

    }
}
