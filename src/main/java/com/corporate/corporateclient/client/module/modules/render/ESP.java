package com.corporate.corporateclient.client.module.modules.render;


import com.corporate.corporateclient.api.util.ColorUtil;
import com.corporate.corporateclient.api.util.RenderUtil;
import com.corporate.corporateclient.client.module.Category;
import com.corporate.corporateclient.client.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.stream.Collectors;

public class ESP extends Module {


    public ESP(){
        super("ESP", "Chinese government", 0, Category.RENDER);
    }





    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent event) {

            for(Entity e: Minecraft.getMinecraft().world.loadedEntityList) {
                if(e instanceof EntityMob) {
                    RenderUtil.entityEspBox(e, 1, new ColorUtil(255, 255,255));
                }
            }


            for (Entity e : Minecraft.getMinecraft().world.loadedEntityList
                    .stream()
                    .filter(entity -> entity != Minecraft.getMinecraft().player)
                    .collect(Collectors.toList())) {
                if (e instanceof EntityPlayer) {
                    RenderUtil.entityEspBox(e, 1, new ColorUtil(255, 255,255));
                }


        }

            for (Entity e : Minecraft.getMinecraft().world.loadedEntityList) {
                if (e instanceof EntityAnimal) {
                    RenderUtil.entityEspBox(e, 1, new ColorUtil(255, 255,255));
                }


        }

    }
}