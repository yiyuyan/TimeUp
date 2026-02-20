package cn.ksmcbrigade.timeup.mixin.client.texture;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TextureAtlasSprite.class)
public class TextureAtlasSpriteMixin {
    @Inject(method = "createTicker",at = @At("HEAD"),cancellable = true)
    public void ticker(CallbackInfoReturnable<TextureAtlasSprite.Ticker> cir){
        if(CommonClass.timing){
            cir.setReturnValue(new TextureAtlasSprite.Ticker() {
                @Override
                public void tickAndUpload() {}

                @Override
                public void close() {}
            });
        }
    }
}
