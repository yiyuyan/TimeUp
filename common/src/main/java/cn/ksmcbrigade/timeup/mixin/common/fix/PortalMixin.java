package cn.ksmcbrigade.timeup.mixin.common.fix;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndGatewayBlock;
import net.minecraft.world.level.block.EndPortalBlock;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {EndPortalBlock.class, EndGatewayBlock.class, NetherPortalBlock.class})
public class PortalMixin {
    @Inject(method = "entityInside",at = @At("HEAD"),cancellable = true)
    public void inside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity, CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }
}
