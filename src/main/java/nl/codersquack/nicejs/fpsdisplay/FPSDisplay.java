package nl.codersquack.nicejs.fpsdisplay;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nl.codersquack.nicejs.fpsdisplay.config.ModConfig;
import nl.codersquack.nicejs.fpsdisplay.mixin.MixinMinecraft;
import org.apache.logging.log4j.Logger;

@Mod(modid = FPSDisplay.MOD_ID, clientSideOnly = true)
public class FPSDisplay {
    //public static File config;
    public static final String MOD_ID = "fpsdisplay";
    private static Logger logger;
    public static Boolean SHOW_FPS_OVERLAY;
    public static FPSHistory fpsHistory = new FPSHistory();
    //private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    //private static final Lock r = rwl.readLock();
    //private static final Lock w = rwl.writeLock();
    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void onPreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        //ConfigHandler.registerConfig(event);
    }
    private static Integer hexColorToInt(String hexc, Integer defaultValue) {
        if (hexc == null) return defaultValue;
        String duck = hexc.replaceAll("^#|0x", "");

        try {
            return Integer.parseInt(duck, 16);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    public static class FunnyEventHandler {
        @SubscribeEvent
        public void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
            // TODO: make the fpshistory logic run every in-game tick instead of every time the event is called
            Minecraft client = Minecraft.getMinecraft();
            int fps = ((MixinMinecraft)client).getCurrentFps();
            //logger.info("FPS: " + fps);
            //logger.info("im mrbeast");
            //fpsHistory.add(fps);
            //r.lock();
            String displayString = String.format("%d FPS (min: %d | avg: %d | max: %d)", fps,
                    fpsHistory.getMinimum(), fpsHistory.getAverage(), fpsHistory.getMaximum());
            //r.unlock();
            //int textPosX = 5; // TODO: change this once configuration is implemented
            //int textPosY = 5;

            // TODO: Prevent text from going outside screenspace
            int w = client.fontRenderer.getStringWidth(displayString);
            client.fontRenderer.drawString(displayString,
                    ModConfig.textPosX, ModConfig.textPosY, hexColorToInt(ModConfig.textColor, 0xffffff));

        }
        @SubscribeEvent
        public void ClientTickEvent(TickEvent.ClientTickEvent event) {
            Minecraft client = Minecraft.getMinecraft();
            int fps = ((MixinMinecraft)client).getCurrentFps();
            //logger.info("FPS: " + fps);
            //logger.info("im mrbeast");
            //r.lock(); // i feel like this is gonna affect performance (im assuming this tick event is the server one and not the client
            //w.lock();
            fpsHistory.add(fps);
            //r.unlock();
            //r.unlock();
        }
    }
    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("Initializing FPS-Display Mod");
        // TODO: Implement config.
        SHOW_FPS_OVERLAY = true;
        //ClientRegistry.registerKeyBinding();
        MinecraftForge.EVENT_BUS.register(new FunnyEventHandler());
        //Minecraft mc = Minecraft.getMinecraft();
        //((MixinMinecraft) mc).setIsDemo(true);

    }
}
