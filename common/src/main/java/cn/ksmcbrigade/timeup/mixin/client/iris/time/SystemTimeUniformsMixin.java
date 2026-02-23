package cn.ksmcbrigade.timeup.mixin.client.iris.time;

import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.uniforms.SystemTimeUniforms;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {SystemTimeUniforms.Timer.class, SystemTimeUniforms.FrameCounter.class},remap = false)
public class SystemTimeUniformsMixin {

    @Inject(method = "beginFrame",at = @At("HEAD"),cancellable = true)
    public void begin(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
