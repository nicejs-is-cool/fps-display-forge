package nl.codersquack.nicejs.fpsdisplay.handlers;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nl.codersquack.nicejs.fpsdisplay.FPSDisplay;

import java.io.File;
// DEPRECATED: Do not use
/*public class ConfigHandler {
    public static Configuration config;

    public static int TEXT_POS_X = 5;
    public static int TEXT_POS_Y = 5;
    public static int TEXT_COLOR = 0xffffff;
    public static String TEXT_FORMAT = "%d FPS (%d min | %d avg | %d max)";
    public static void init(File file) {
        config = new Configuration(file);
        String category;
        category = "General";
        config.addCustomCategoryComment(category, "General configuration for FPS Display.");
        TEXT_POS_X = config.getInt("Text Position X", category, 5, 1, 8192, "X Position for the text overlay on screen.");
        TEXT_POS_Y = config.getInt("Text Position Y", category, 5, 1, 8192, "Y Position for the text overlay on screen.");
        TEXT_COLOR = config.getInt("Text Color", category, 0xffffff, 0, 0xffffff, "Color for the text overlay on screen in decimal (convert the color from hex).");
        TEXT_FORMAT = config.getString("Text Format", category, "%d FPS (%d min | %d avg | %d max)", "Value passed to String.format for displaying the text.");

        config.save();
    }
    public static void registerConfig(FMLPreInitializationEvent event) {
        FPSDisplay.config = new File(event.getModConfigurationDirectory() + "/" + FPSDisplay.MOD_ID);
        FPSDisplay.config.mkdirs();
        init(new File(FPSDisplay.config.getPath(), FPSDisplay.MOD_ID + ".cfg"));
    }
}
*/