package cn.ksmcbrigade.timeup.mixin.common.fix;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.DimensionTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ServerPlayer.class})
public class ServerPlayerMixin {

    @Inject(method ={"changeDimension"},at = @At("HEAD"),cancellable = true)
    public void changeD(DimensionTransition pTransition, CallbackInfoReturnable<Entity> cir){
        if(CommonClass.timing) cir.setReturnValue((Entity) ((Object) this));
    }
}
