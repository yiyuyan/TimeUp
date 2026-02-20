package cn.ksmcbrigade.timeup.mixin.client.renderer;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.entity.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Display.class)
public class DisplayMixin {
    @Inject(method = {"tick"},at = @At("HEAD"),cancellable = true)
    private void tick(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
