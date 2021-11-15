package com.corporate.corporateclient.client.module.modules.client;

import com.corporate.corporateclient.client.gui.ClickGui.ClickGui;
import com.corporate.corporateclient.client.module.Category;
import com.corporate.corporateclient.client.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGuiModule extends Module {

    public ClickGuiModule() {
        super("ClickGui", "Gui for modules and settings", Keyboard.KEY_RSHIFT, Category.CLIENT);
    }



    public void onEnable() {
        toggle();
        Minecraft.getMinecraft().displayGuiScreen(new ClickGui());
    }




}
