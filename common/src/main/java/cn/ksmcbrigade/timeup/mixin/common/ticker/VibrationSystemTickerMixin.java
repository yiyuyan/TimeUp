package cn.ksmcbrigade.timeup.mixin.common.ticker;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VibrationSystem.Ticker.class)
public interface VibrationSystemTickerMixin {
    @Inject(method = "tick",at = @At("HEAD"),cancellable = true)
    private static void tick(Level pLevel, VibrationSystem.Data pData, VibrationSystem.User pUser, CallbackInfo ci){

        if(CommonClass.timing) ci.cancel();
    }
}
