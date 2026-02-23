package cn.ksmcbrigade.timeup.mixin.client.iris.cache;

import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.uniforms.custom.CustomUniforms;
import net.irisshaders.iris.uniforms.custom.cached.CachedUniform;
import net.irisshaders.iris.uniforms.custom.cached.Float4MatrixCachedUniform;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = CustomUniforms.class,remap = false)
public class CustomUniformsMixin {
    @Shadow @Final private List<CachedUniform> uniformOrder;

    @Inject(method = "update",at = @At("HEAD"),cancellable = true)
    public void custom(CallbackInfo ci){
        if(CommonClass.timing){
            for (CachedUniform cachedUniform : uniformOrder) {
                String l = cachedUniform.getName().toLowerCase();
                if(l.contains("camera") || l.contains("view") || l.contains("isEyeInWater")){
                    if(uniformOrder instanceof Float4MatrixCachedUniform && cachedUniform.getName().contains("tex")){
                        continue;
                    }
                    cachedUniform.update();
                }
            }
            ci.cancel();
        }
    }
}
