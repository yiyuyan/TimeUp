package cn.ksmcbrigade.timeup.mixin.network;

import cn.ksmcbrigade.timeup.CommonClass;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(ChatComponent.class)
public class ChatMixin {
    @ModifyVariable(
            method = "addMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/MessageSignature;Lnet/minecraft/client/GuiMessageTag;)V",
            at = @At("HEAD"),
            ordinal = 0,index = 1, argsOnly = true)
    public Component modifyMessage(Component value){
        String s = value.getString();
        if(s.startsWith("_tcz_") && s.length()>=9 && s.length()<=10){
            CommonClass.timing = Boolean.parseBoolean(s.replace("_tcz_",""));
            value = Component.literal("Timing: "+CommonClass.timing);
        }
        return value;
    }
}
