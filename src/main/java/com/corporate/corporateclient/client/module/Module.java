package com.corporate.corporateclient.client.module;

import com.corporate.corporateclient.Corporate;


import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class Module {
    public String name;
    public int key;
    public Category category;
    public boolean toggled;
    public String description;

    public Module(String name, String description, int key, Category category) {
        this.name = name;
        this.key = key;
        this.category = category;
        this.description = description;
    }

    public void toggle() {
        toggled = !toggled;
        if(toggled) {
            enable();
        }
        else
            disable();
    }
    public void update(){}
    public void render(){}

    public void onRender(){

    }

    public void onRenderWorldLast(float partialTicks) {}


    public void enable() {
        Corporate.EVENT_BUS.subscribe(this);
        MinecraftForge.EVENT_BUS.register(this);
        onEnable();
    }
    public void disable() {
        Corporate.EVENT_BUS.unsubscribe(this);
        MinecraftForge.EVENT_BUS.unregister(this);
        onDisable();
    }
    public void onEnable() {}
    public void onDisable() {}



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isToggled() {
        return toggled;
    }
    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }







}
