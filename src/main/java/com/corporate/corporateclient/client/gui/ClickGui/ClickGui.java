package com.corporate.corporateclient.client.gui.ClickGui;


import com.corporate.corporateclient.Corporate;
import com.corporate.corporateclient.client.gui.ClickGui.Buttons.ModuleButton;
import com.corporate.corporateclient.client.module.Category;
import com.corporate.corporateclient.client.module.Module;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ClickGui extends GuiScreen {



    public ArrayList<Frame> frames;
    public ClickGui() {
        int offset = 50;
        frames = new ArrayList<>();
        for(Category c : Category.values()) {
            Frame frame = new Frame(c.name(),4 + offset, 30, 79, 13);
            for(Module m : Corporate.instance.moduleManager.getModsInCategory(c)) {
                ModuleButton button = new ModuleButton(frame, m);
                frame.buttons.add(button);
            }
            frames.add(frame);
            offset += 80;

        }

        Gui.drawRect(100, 300, 150, 330, new Color(40,40,40).getRGB());
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        for(Frame f : frames){
            f.mouseReleased(mouseX, mouseY, state);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for(Frame f : frames){
            f.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        for(Frame f: frames) {
            f.update(mouseX, mouseY);
            f.drawScreen(mouseX, mouseY, partialTicks);

        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
