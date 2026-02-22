package cn.ksmcbrigade.timeup.mixin.client.iris;

import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.uniforms.WorldTimeUniforms;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = WorldTimeUniforms.class,remap = false)
public class WorldTimeUniformsMixin {

    @Unique
    private static int day = -1,time = -114;

    @Inject(method = "getWorldDay",at = @At("RETURN"),cancellable = true)
    private static void u(CallbackInfoReturnable<Integer> cir){
        if(CommonClass.timing){
            if(day==-1) day = cir.getReturnValue();
            cir.setReturnValue(day);
        }
        else{
            day = -1;
            time = -114;
        }
    }

    @Inject(method = "getWorldDayTime",at = @At("RETURN"),cancellable = true)
    private static void u2(CallbackInfoReturnable<Integer> cir){
        if(CommonClass.timing){
            if(time==-114) time = cir.getReturnValue();
            cir.setReturnValue(time);
        }
        else{
            time = -114;
        }
    }
}
