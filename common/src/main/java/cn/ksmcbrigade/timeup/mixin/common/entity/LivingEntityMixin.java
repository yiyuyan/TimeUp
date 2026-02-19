package cn.ksmcbrigade.timeup.mixin.common.entity;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = {"tick","rideTick","baseTick","tickDeath","tickEffects","tickRidden","aiStep","serverAiStep"},at = @At("HEAD"),cancellable = true)
    public void ticking(CallbackInfo ci){
        Entity self = (Entity) ((Object) this);
        if(CommonClass.timing && !(self instanceof Player)) ci.cancel();
    }
}
