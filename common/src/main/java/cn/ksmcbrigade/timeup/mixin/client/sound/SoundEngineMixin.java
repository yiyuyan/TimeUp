package cn.ksmcbrigade.timeup.mixin.client.sound;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.sounds.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundEngine.class)
public abstract class SoundEngineMixin {
    @Shadow public abstract void pause();

    @Inject(method = {"tick","tickNonPaused","queueTickingSound"},at = @At("HEAD"),cancellable = true)
    public void tick(CallbackInfo ci){
        if(CommonClass.timing){
            this.pause();
            ci.cancel();
        }
    }
}
