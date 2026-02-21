package cn.ksmcbrigade.timeup.mixin.common.ticker;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.vibrations.VibrationInfo;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VibrationSystem.Ticker.class)
public interface VibrationSystemTickerMixin {
    @Shadow
    private static void trySelectAndScheduleVibration(ServerLevel p_282775_, VibrationSystem.Data p_282792_, VibrationSystem.User p_281845_) {

    }

    @Shadow
    private static void tryReloadVibrationParticle(ServerLevel p_282010_, VibrationSystem.Data p_282354_, VibrationSystem.User p_282958_) {

    }

    @Shadow
    private static boolean receiveVibration(ServerLevel p_282967_, VibrationSystem.Data p_283447_, VibrationSystem.User p_282301_, VibrationInfo p_281498_) {
        return false;
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    static void tick(Level pLevel, VibrationSystem.Data pData, VibrationSystem.User pUser) {
        if (pLevel instanceof ServerLevel serverlevel) {
            if (pData.getCurrentVibration() == null) {
                trySelectAndScheduleVibration(serverlevel, pData, pUser);
            }

            if (pData.getCurrentVibration() != null) {
                boolean flag = pData.getTravelTimeInTicks() > 0;
                tryReloadVibrationParticle(serverlevel, pData, pUser);
                pData.decrementTravelTime();
                if (pData.getTravelTimeInTicks() <= 0) {
                    flag = receiveVibration(serverlevel, pData, pUser, pData.getCurrentVibration());
                }

                if (flag) {
                    pUser.onDataChanged();
                }
            }
        }

    }
}
