package cn.ksmcbrigade.timeup.mixin.client.shader;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.renderer.EffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EffectInstance.class)
public class EffectInstanceMixin {
    @Inject(method = "updateLocations",at = @At("HEAD"), cancellable = true)
    public void no_update(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
