package cn.ksmcbrigade.timeup.mixin.common.fluid;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidState.class)
public class FluidStateMixin {
    @Inject(method = {"tick","animateTick","randomTick"},at = @At("HEAD"),cancellable = true)
    public void tick(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }

    @Inject(method = {"isRandomlyTicking"},at = @At("HEAD"),cancellable = true)
    public void tick(CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(false);
    }
}
