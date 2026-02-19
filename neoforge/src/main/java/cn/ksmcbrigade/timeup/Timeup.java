package cn.ksmcbrigade.timeup;


import cn.ksmcbrigade.timeup.commands.TCommand;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod(Constants.MOD_ID)
public class Timeup {

    public Timeup(IEventBus eventBus) {
        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        CommonClass.init();
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void command(RegisterCommandsEvent event){
        TCommand.register(event.getDispatcher());
    }
}
