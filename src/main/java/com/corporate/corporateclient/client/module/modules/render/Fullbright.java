package com.corporate.corporateclient.client.module.modules.render;

import com.corporate.corporateclient.client.module.Category;
import com.corporate.corporateclient.client.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Fullbright extends Module {

    public Fullbright() {
        super("Fullbright", "Makes everything bright", Keyboard.KEY_P, Category.RENDER);
    }

    Float oldgamma = Minecraft.getMinecraft().gameSettings.gammaSetting;

    public void onEnable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 100f;
    }


    public void onDisable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = oldgamma;
    }
}
