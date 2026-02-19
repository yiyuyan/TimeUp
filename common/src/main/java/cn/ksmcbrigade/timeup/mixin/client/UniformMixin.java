package cn.ksmcbrigade.timeup.mixin.client;

import cn.ksmcbrigade.timeup.CommonClass;
import com.mojang.blaze3d.shaders.Uniform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Uniform.class)
public abstract class UniformMixin {

    @Shadow public abstract String getName();

    @Unique
    private boolean set = false;

    @Inject(method = {
            "set(F)V",
            "set([F)V",
    },at = @At("HEAD"),cancellable = true)
    private void set(CallbackInfo ci){
        if(CommonClass.timing && set){
            ci.cancel();
        }
        set = true;
    }

    @Inject(method = {
            "set(Lorg/joml/Matrix4f;)V",
    },at = @At("HEAD"),cancellable = true)
    private void set2(CallbackInfo ci){
        if(CommonClass.timing && set && getName().equals("TextureMat")){
            ci.cancel();
        }
        set = true;
    }
}
