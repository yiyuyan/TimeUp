package cn.ksmcbrigade.timeup.mixin.client.particle;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.particle.Particle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Particle.class)
public abstract class ParticleMixin {

    @Inject(method = "tick",at = @At("HEAD"),cancellable = true)
    public void tick(CallbackInfo ci){
        if(CommonClass.timing){
            ci.cancel();
        }
    }
}
