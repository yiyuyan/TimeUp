package cn.ksmcbrigade.timeup.commands;

import cn.ksmcbrigade.timeup.CommonClass;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class TCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("time-up").executes(context -> {
            CommonClass.timing = !CommonClass.timing;
            context.getSource().sendSystemMessage(Component.literal("_tcz_"+CommonClass.timing));
            return 0;
        }));
    }
}
