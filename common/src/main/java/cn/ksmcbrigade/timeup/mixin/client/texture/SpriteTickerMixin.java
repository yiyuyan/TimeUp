package cn.ksmcbrigade.timeup.mixin.client.texture;

import cn.ksmcbrigade.timeup.CommonClass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.client.renderer.texture.SpriteContents$Ticker")
public class SpriteTickerMixin {
    @Inject(method = "tickAndUpload",at = @At("HEAD"),cancellable = true)
    public void up(int p_249105_, int p_249676_, CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
