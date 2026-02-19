package cn.ksmcbrigade.timeup.mixin.common.entity;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = {"isAlwaysTicking"},at = @At("HEAD"),cancellable = true)
    public void ticking(CallbackInfoReturnable<Boolean> cir){
        Entity self = (Entity) ((Object) this);
        if(CommonClass.timing && !(self instanceof Player)) cir.setReturnValue(false);
    }

    @Inject(method = {"tick","rideTick","baseTick"},at = @At("HEAD"),cancellable = true)
    public void ticking(CallbackInfo ci){
        Entity self = (Entity) ((Object) this);
        if(CommonClass.timing && !(self instanceof Player)) ci.cancel();
    }
}
