package com.corporate.corporateclient.api.event;

import com.corporate.corporateclient.Corporate;
import com.corporate.corporateclient.client.module.ModuleManager;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

import java.util.Map;

public class EventProcessor {

    public static EventProcessor instance;
    Minecraft mc = Minecraft.getMinecraft();

    public EventProcessor() {
        instance = this;
        Corporate.EVENT_BUS.subscribe(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().player != null) {
            ModuleManager.update();
        }
    }


    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent event) {
        if (event.isCanceled()) {
            return;
        }
        ModuleManager.onWorldRender(event);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        Corporate.EVENT_BUS.post(event);
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            ModuleManager.onRender();
        }
    }

    @SubscribeEvent
    public void onMouseInput(InputEvent.MouseInputEvent event) {
        if (Mouse.getEventButtonState()) {
            Corporate.EVENT_BUS.post(event);
        }
    }

    @SubscribeEvent
    public void onRenderScreen(RenderGameOverlayEvent.Text event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onDrawBlockHighlight(DrawBlockHighlightEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onRenderBlockOverlay(RenderBlockOverlayEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onLivingEntityUseItemFinish(LivingEntityUseItemEvent.Finish event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onPlayerPush(PlayerSPPushOutOfBlocksEvent event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        Corporate.EVENT_BUS.post(event);
    }
    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        Corporate.EVENT_BUS.post(event);
    }



    private final Map<String, String> uuidNameCache = Maps.newConcurrentMap();



}