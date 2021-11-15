package com.corporate.corporateclient.client.gui.ClickGui.Buttons;

import com.corporate.corporateclient.client.gui.ClickGui.Frame;
import com.corporate.corporateclient.client.module.Module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.io.IOException;


public class ModuleButton extends Gui{
    public com.corporate.corporateclient.client.gui.ClickGui.Frame parent;
    public Module module;
    public int offset;



    public ModuleButton(Frame parent, Module module) {
        this.parent = parent;
        this.module = module;
    }

    public void update(int mouseX, int mouseY){}


    public void mouseReleased(int mouseX, int mouseY, int state) {}

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if(mouseButton == 0) {
            if(bounding(mouseX, mouseY)) {
                module.toggle();
            }
        }
    }

    public void keyTyped(char typedChar, int keyCode) throws IOException {}


    public void drawScreen(int mouseX, int mouseY, float partialTicks,int offset) {
        this.offset = offset;

        Color buttoncolor = new Color(30, 30,30);
        final int[] counter = {1};
        Gui.drawRect(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.barheight, module.isToggled() ?   new Color(30,30, 30).getRGB() : new Color(45, 45, 45).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(module.getName(), parent.x + 2, parent.y + offset + 2, new Color(255, 255, 255).getRGB());
        counter[0]++;
    }


    public boolean bounding(int mouseX,int mouseY) {
        if(mouseX >= this.parent.x && mouseX <= this.parent.x + this.parent.width && mouseY >= this.parent.y + offset && mouseY <= this.parent.y + offset + parent.barheight) {
            return true;
        }
        else{
            return false;
        }
    }
}
