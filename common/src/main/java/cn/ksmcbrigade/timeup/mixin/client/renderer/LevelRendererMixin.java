package cn.ksmcbrigade.timeup.mixin.client.renderer;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
    @Inject(method = "tickRain",at = @At("HEAD"),cancellable = true)
    public void rain(Camera pCamera, CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
