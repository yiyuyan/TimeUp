package cn.ksmcbrigade.timeup.mixin.common.ticker;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.gametest.framework.GameTestTicker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameTestTicker.class)
public class GameTestTickerMixin {
    @Inject(method = "tick",at = @At("HEAD"),cancellable = true)
    public void tick(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
