package cn.ksmcbrigade.timeup.mixin.common.fix;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.DimensionTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method ={"canChangeDimensions","canUsePortal"},at = @At("HEAD"),cancellable = true)
    public void change(CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(false);
    }

    @Inject(method ={"setAsInsidePortal","handlePortal"},at = @At("HEAD"),cancellable = true)
    public void change(CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }

    @Inject(method ="changeDimension",at = @At("HEAD"),cancellable = true)
    public void changeD(DimensionTransition pTransition, CallbackInfoReturnable<Entity> cir){
        if(CommonClass.timing) cir.setReturnValue((Entity) ((Object) this));
    }
}
