package com.corporate.corporateclient.client.gui.ClickGui;


import com.corporate.corporateclient.Corporate;
import com.corporate.corporateclient.client.gui.ClickGui.Buttons.ModuleButton;
import com.corporate.corporateclient.client.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class Frame {

    public String name;
    public int x;
    public int y;
    public int width;
    public int height;
    public int dragx;
    public int dragy;
    public boolean hovered;
    public boolean dragging;
    public boolean open;
    public int offset;
    public int barheight;
    public ArrayList<ModuleButton> buttons;



    public Frame(String name, int x, int y, int width, int barheight) {
        this.name = name;
        this.x = x;
        this.barheight = barheight;
        this.y = y;
        this.width = width;
        this.height = 200;
        buttons = new ArrayList<ModuleButton>();
    }

    public void update(int mouseX, int mouseY) {
        if (dragging) {
            x = mouseX - dragx;
            y = mouseY - dragy;
        }
        for (ModuleButton b : buttons) {
            b.update(mouseX, mouseY);

        }
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        dragging = false;
        for (ModuleButton b : buttons) {
            b.mouseReleased(mouseX, mouseY, state);
        }
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (mouseButton == 0) {
            if (bounding(mouseX, mouseY)) {
                dragging = true;
                this.dragx = mouseX - x;
                this.dragy = mouseY - y;
            }
        }
        for (ModuleButton b : buttons) {
            b.mouseClicked(mouseX, mouseY, mouseButton);

        }
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        for (ModuleButton b : buttons) {
            b.keyTyped(typedChar, keyCode);

        }

    }

    // Bar drawing
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        String category = name.toLowerCase();
        String cName = category.substring(0, 1).toUpperCase() + category.substring(1);
        final int[] counter = {1};
        Gui.drawRect(x , y, x + width, y + barheight, new Color(50, 131, 209).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(cName, x + 2, y + 2, new Color(255, 255, 255).getRGB());
        counter[0]++;

        offset = barheight;
        for (ModuleButton b : buttons) {
            b.drawScreen(mouseX, mouseY, partialTicks, offset);
            offset += barheight;

        }
    }

    public void drawSettings(int mouseX, int mouseY, float partialTicks) {
        Gui.drawRect(100, 300, 150, 330, new Color(40,40,40).getRGB());

    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks, int offset) {
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

        for (Module mod : Corporate.instance.moduleManager.getModules()) {
            int y = 2;
            if (mod.isToggled()) {
                fr.drawStringWithShadow(mod.getName(), sr.getScaledHeight() - fr.getStringWidth(mod.getName()) - 2, y, 0xffffffff);
                y += fr.FONT_HEIGHT;
            }
        }

    }



    public boolean bounding(int mouseX,int mouseY) {
        if(mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + barheight) {
            return true;
        }
        else{
            return false;
        }
    }
    public static int rainbow(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
