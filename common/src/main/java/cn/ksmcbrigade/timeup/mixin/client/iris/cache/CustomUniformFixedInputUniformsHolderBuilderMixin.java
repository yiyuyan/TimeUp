package cn.ksmcbrigade.timeup.mixin.client.iris.cache;

import cn.ksmcbrigade.timeup.CommonClass;
import net.irisshaders.iris.uniforms.custom.CustomUniformFixedInputUniformsHolder;
import net.irisshaders.iris.uniforms.custom.cached.CachedUniform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CustomUniformFixedInputUniformsHolder.Builder.class,remap = false)
public class CustomUniformFixedInputUniformsHolderBuilderMixin {
    @Inject(method = "put",at = @At("HEAD"),cancellable = true)
    public void put(String name, CachedUniform uniform, CallbackInfoReturnable<CustomUniformFixedInputUniformsHolder.Builder> cir){
        if(!CommonClass.timing) return;
        String n = name.toLowerCase();
        if(n.contains("pos") || n.contains("tex") || n.contains("color") || n.contains("angle") || n.contains("time")){
            cir.setReturnValue((CustomUniformFixedInputUniformsHolder.Builder) ((Object) this));
        }
    }
}
