package com.corporate.corporateclient.client.module;

import com.corporate.corporateclient.api.util.RenderUtil;
import com.corporate.corporateclient.client.module.modules.client.ClickGuiModule;
import com.corporate.corporateclient.client.module.modules.render.ESP;
import com.corporate.corporateclient.client.module.modules.render.Fullbright;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class ModuleManager {
    public static ArrayList<Module> modules;

    public ModuleManager() {
        modules = new ArrayList<Module>();
        MinecraftForge.EVENT_BUS.register(this);
        init();
    }
    public void init() {

        //render
        modules.add(new Fullbright());
        modules.add(new ESP());

        //client
        modules.add(new ClickGuiModule());

        //exploits


    }

    public static void update(){
        modules.stream().filter(Module::isToggled).forEach(Module::render);
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
    public Module getModule(String name) {
        for(Module m : modules) {
            if(m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
    public ArrayList<Module> getModsInCategory(Category cat) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for(Module m : modules) {
            if(m.getCategory() == cat) {
                mods.add(m);
            }
        }
        return mods;
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        for(Module m: modules) {
            if(m.isToggled()) {
                m.update();
            }
        }
    }
    @SubscribeEvent
    public static void onRender(RenderWorldLastEvent event){
        for(Module mod: modules) {
            if(mod.isToggled()) {
                mod.render();
            }
        }

    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if(Keyboard.getEventKeyState()) {
            for(Module m: modules) {
                if(m.getKey() == Keyboard.getEventKey()){
                    m.toggle();
                }
            }

        }

    }

    //thanks moobase :)
    public static void onWorldRender(RenderWorldLastEvent event) {
        Minecraft.getMinecraft().mcProfiler.startSection("Corporate");
        Minecraft.getMinecraft().mcProfiler.startSection("setup");
        RenderUtil.prepare();
        Minecraft.getMinecraft().mcProfiler.endSection();

        modules.stream().filter(module -> module.isToggled()).forEach(module -> {
            Minecraft.getMinecraft().mcProfiler.startSection(module.getName());
            Minecraft.getMinecraft().mcProfiler.endSection();
        });

        Minecraft.getMinecraft().mcProfiler.startSection("release");
        RenderUtil.release();
        Minecraft.getMinecraft().mcProfiler.endSection();
        Minecraft.getMinecraft().mcProfiler.endSection();
    }
    public static void onRender(){
        modules.stream().filter(Module::isToggled).forEach(Module::render);
    }


}
