package cn.ksmcbrigade.timeup.mixin.common.block;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public class BlockStateBaseMixin {
    @Inject(method = {"tick","randomTick"},at = @At("HEAD"),cancellable = true)
    public void tick(ServerLevel pLevel, BlockPos pPos, RandomSource pRandom, CallbackInfo ci){
        if(CommonClass.timing) ci.cancel();
    }

    @Inject(method = {"isRandomlyTicking"},at = @At("HEAD"),cancellable = true)
    public void tick(CallbackInfoReturnable<Boolean> cir){
        if(CommonClass.timing) cir.setReturnValue(false);
    }

    @Inject(method = "getTicker",at = @At("HEAD"),cancellable = true)
    public <T extends BlockEntity> void ticker(Level pLevel, BlockEntityType<T> pBlockEntityType, CallbackInfoReturnable<BlockEntityTicker<T>> cir){
        if(CommonClass.timing){
            cir.setReturnValue((level, blockPos, blockState, t) -> {});
        }
    }
}
