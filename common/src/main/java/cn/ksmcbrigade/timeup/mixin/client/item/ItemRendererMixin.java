package cn.ksmcbrigade.timeup.mixin.client.item;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.lighting.SkyLightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Unique
    private Map<ItemStack,BakedModel> timeUp$modelMap = new HashMap<>();

    @Inject(method = "getModel",at = @At("RETURN"),cancellable = true)
    public void resolve(ItemStack pStack, Level pLevel, LivingEntity pEntity, int pSeed, CallbackInfoReturnable<BakedModel> cir){
        if(CommonClass.timing){
            if(!timeUp$modelMap.containsKey(pStack)) timeUp$modelMap.put(pStack,cir.getReturnValue());
            cir.setReturnValue(timeUp$modelMap.get(pStack));
        }
        else{
            timeUp$modelMap.clear();
        }
    }
}
