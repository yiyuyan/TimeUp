package cn.ksmcbrigade.timeup.mixin.common.fix;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method ="canChangeDimensions",at = @At("HEAD"),cancellable = true)
    public void change(Level pOldLevel, Level pNewLevel, CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(false);
    }
}
