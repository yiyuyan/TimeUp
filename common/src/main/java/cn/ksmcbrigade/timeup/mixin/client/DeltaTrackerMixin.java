package cn.ksmcbrigade.timeup.mixin.client;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.DeltaTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DeltaTracker.Timer.class)
public abstract class DeltaTrackerMixin {
    @Shadow protected abstract void pause();

    @Shadow public abstract void updateFrozenState(boolean p_344005_);

    @Inject(method = "getGameTimeDeltaPartialTick",at = @At("HEAD"),cancellable = true)
    public void delta(boolean pRunsNormally, CallbackInfoReturnable<Float> cir){
        if(CommonClass.timing){
            this.pause();
            this.updateFrozenState(true);
            cir.setReturnValue(0F);
        }
    }
}
