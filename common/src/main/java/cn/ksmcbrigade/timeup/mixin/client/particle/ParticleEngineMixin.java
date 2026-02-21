package cn.ksmcbrigade.timeup.mixin.client.particle;

import cn.ksmcbrigade.timeup.CommonClass;
import cn.ksmcbrigade.timeup.mixin.client.accessors.CameraAccessor;
import cn.ksmcbrigade.timeup.records.CameraRecord;
import net.minecraft.client.Camera;
import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleEngine.class)
public class ParticleEngineMixin {
    @Inject(method = {"tick","tickParticle","tickParticleList"},at = @At("HEAD"),cancellable = true)
    public void tick(CallbackInfo ci){
        if(CommonClass.timing){
            ci.cancel();
        }
    }


}
