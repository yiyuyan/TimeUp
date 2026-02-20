package cn.ksmcbrigade.timeup.mixin.common.light;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.lighting.LightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightEngine.class)
public class LightEngineMixin {
    @Inject(method = {"runLightUpdates"},at = @At("HEAD"),cancellable = true)
    public void up(CallbackInfoReturnable<Integer> cir){
        if(CommonClass.timing) cir.setReturnValue(0);
    }
}
