package cn.ksmcbrigade.timeup.mixin.common.effect;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEffectInstance.class)
public class MobEffectInstanceMixin {
    @Inject(method = "update",at = @At("HEAD"),cancellable = true)
    private void up(MobEffectInstance pOther, CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(true);
    }

    @Inject(method = {"tick"},at = @At("HEAD"),cancellable = true)
    private void tick(LivingEntity pEntity, Runnable pOnExpirationRunnable, CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(true);
    }
}
