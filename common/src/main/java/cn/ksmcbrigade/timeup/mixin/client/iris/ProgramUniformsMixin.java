package cn.ksmcbrigade.timeup.mixin.client.iris;


import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.gl.program.ProgramUniforms;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ProgramUniforms.class,remap = false)
public class ProgramUniformsMixin {
    @Inject(method = "update",at = @At("HEAD"),cancellable = true)
    public void up(CallbackInfo ci){
        if(CommonClass.timing){
            ci.cancel();
        }
    }
}
