package cn.ksmcbrigade.timeup.mixin.client.iris;

import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.uniforms.IrisTimeUniforms;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = IrisTimeUniforms.class,remap = false)
public class IrisTimeUniformsMixin {
    @Inject(method = "updateTime",at = @At("HEAD"),cancellable = true)
    private static void u(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
