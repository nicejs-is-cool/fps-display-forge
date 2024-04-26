package nl.codersquack.nicejs.fpsdisplay.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.server.command.TextComponentHelper;
import nl.codersquack.nicejs.fpsdisplay.FPSDisplay;

@Config(modid = FPSDisplay.MOD_ID)
@Config.LangKey(FPSDisplay.MOD_ID + ".config.title")
public class ModConfig {
    @Config.Name("X Position")
    public static int textPosX = 5;
    @Config.Name("Y Position")
    public static int textPosY = 5;
    @Config.Name("Text color")
    public static String textColor = "ffffff";
    //@Config.Name(FPSDisplay.MOD_ID + ".config.text.format")
    //public static String textFormat = "0xffffff";

    @Mod.EventBusSubscriber(modid = FPSDisplay.MOD_ID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (!event.getModID().equals(FPSDisplay.MOD_ID)) return;

            ConfigManager.sync(FPSDisplay.MOD_ID, Config.Type.INSTANCE);
            //System.out.println(String.format("X: %d; Y: %d; Color: %s;", textPosX, textPosY, textColor));

        }
    }

}
