package nl.codersquack.nicejs.fpsdisplay.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiOverlayDebug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class MixinGuiIngame {
    @Inject(at = @At("TAIL"), method = "renderGameOverlay")
    public void renderGameOverlay(float idk, CallbackInfo info) {
        System.out.println("HERE!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Minecraft client = Minecraft.getMinecraft();
        String displayString = ((MixinMinecraft) client).getCurrentFps() + " FPS";
        System.out.println("duck: " + displayString);
        int textPosX = 20; // TODO: change this once configuration is implemented
        int textPosY = 20;

        int w = ((GuiIngame)(Object)this).getFontRenderer().getStringWidth(displayString);
        ((GuiIngame)(Object)this).getFontRenderer().drawString(displayString, textPosX, textPosY, 0xffffff);

    }

}
