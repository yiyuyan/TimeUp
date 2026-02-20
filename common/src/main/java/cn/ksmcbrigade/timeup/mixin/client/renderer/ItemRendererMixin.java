package cn.ksmcbrigade.timeup.mixin.client.renderer;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Inject(method = "getModel",at = @At("RETURN"),cancellable = true)
    private void model(ItemStack pStack, Level pLevel, LivingEntity pEntity, int pSeed, CallbackInfoReturnable<BakedModel> cir){
        if(pStack.getItem().equals(Items.CLOCK) && CommonClass.timing){
            System.out.println(cir.getReturnValue());
            System.out.println(cir.getReturnValue().isCustomRenderer());
            System.out.println(cir.getReturnValue().getClass().getName());
            System.out.println(cir.getReturnValue().getTransforms().getClass().getName());
            System.out.println(cir  .getReturnValue().getOverrides().getClass().getName());
        }
    }
}
