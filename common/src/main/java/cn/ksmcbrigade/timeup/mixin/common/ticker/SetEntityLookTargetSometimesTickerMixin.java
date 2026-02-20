package cn.ksmcbrigade.timeup.mixin.common.ticker;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.behavior.SetEntityLookTargetSometimes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SetEntityLookTargetSometimes.Ticker.class)
public class SetEntityLookTargetSometimesTickerMixin {
    @Inject(method = "tickDownAndCheck",at = @At("HEAD"),cancellable = true)
    public void tick(RandomSource pRandom, CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(true);
    }
}
