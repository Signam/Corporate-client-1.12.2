package com.corporate.corporateclient.mixin;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

public class CorporateMixinLoader implements IFMLLoadingPlugin {

    public CorporateMixinLoader(){
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.corporate.json");
    }

    @Override
    public String[] getASMTransformerClass(){
        return new String[0];
    }

    @Override
    public String getModContainerClass(){
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass(){
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data){
    }

    @Override
    public String getAccessTransformerClass(){
        return null;
    }
}