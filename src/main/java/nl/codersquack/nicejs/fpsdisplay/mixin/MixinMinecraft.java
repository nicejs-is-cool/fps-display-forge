package nl.codersquack.nicejs.fpsdisplay.mixin;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.PixelFormat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Minecraft.class)
public interface MixinMinecraft {
    @Accessor("debugFPS")
    int getCurrentFps();
    @Accessor("isDemo") // totally not used for testing if i was going insane or if the mixins were working
    public void setIsDemo(boolean bool);
}
