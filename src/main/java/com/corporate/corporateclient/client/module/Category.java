package com.corporate.corporateclient.client.module;

public enum Category {


    EXPLOITS("Exploits"),
    RENDER("Render"),
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    CLIENT("Client"),
    WORLD("World");

    public String name;
    Category(String name){
        this.name = name;
    }


}
