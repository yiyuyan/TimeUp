package cn.ksmcbrigade.timeup;

import cn.ksmcbrigade.timeup.commands.TCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class Timeup {

    public Timeup() {
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.

        CommonClass.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void command(RegisterCommandsEvent event){
        TCommand.register(event.getDispatcher());
    }
}
