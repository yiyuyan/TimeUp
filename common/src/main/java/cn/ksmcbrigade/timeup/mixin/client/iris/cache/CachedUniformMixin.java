package cn.ksmcbrigade.timeup.mixin.client.iris.cache;

import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.uniforms.custom.cached.CachedUniform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CachedUniform.class,remap = false)
public abstract class CachedUniformMixin {
    @Shadow public abstract String getName();

    @Shadow protected abstract boolean doUpdate();

    @Inject(method = "update",at = @At("HEAD"),cancellable = true)
    public void put(CallbackInfo ci){
        if(!CommonClass.timing) return;
        String l = getName().toLowerCase();
        if(l.contains("camera") || l.contains("view") || l.contains("isEyeInWater")){
            doUpdate();
        }
        ci.cancel();
    }
}
