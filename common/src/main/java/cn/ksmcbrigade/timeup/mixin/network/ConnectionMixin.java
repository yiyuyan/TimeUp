package cn.ksmcbrigade.timeup.mixin.network;

import net.minecraft.network.Connection;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class ConnectionMixin {
    @Inject(method = "send(Lnet/minecraft/network/protocol/Packet;Lnet/minecraft/network/PacketSendListener;Z)V",at = @At("HEAD"),cancellable = true)
    public void sent(Packet<?> pPacket, PacketSendListener pListener, boolean pFlush, CallbackInfo ci){
        if(pPacket instanceof ServerboundChatPacket serverboundChatPacket){
            if(serverboundChatPacket.message().startsWith("_tcz_") &&
                    serverboundChatPacket.message().length()>=9 &&
                    serverboundChatPacket.message().length()<=10){
                ci.cancel();
            }
        }
    }
}
