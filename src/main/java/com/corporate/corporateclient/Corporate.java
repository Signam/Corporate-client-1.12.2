package com.corporate.corporateclient;



import com.corporate.corporateclient.client.gui.ClickGui.ClickGui;
import com.corporate.corporateclient.client.module.ModuleManager;
import me.zero.alpine.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Corporate.modid, name = Corporate.name, version = Corporate.version)
public class Corporate {

    public static final String modid = "corporate";
    public static final String version = "v1.0";
    public static final String name = "Corporate 1.12.2";



    @Mod.Instance
    public static Corporate instance = new Corporate();
    public static final EventManager EVENT_BUS = new EventManager();
    public static Corporate getInstance() {return instance;}

    public ModuleManager moduleManager;
    public ClickGui clickGui;





    @Mod.EventHandler
    public void init(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(instance);

        moduleManager = new ModuleManager();
        clickGui = new ClickGui();



    }

}
