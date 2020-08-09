package io.github.qingchenw.allowcolor;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraftforge.common.MinecraftForge;

public class AllowColorContainer extends DummyModContainer {
    public AllowColorContainer() {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "allowcolor";
        meta.name = "Allow Color";
        meta.version = "@version@";
        meta.authorList = Arrays.asList(new String[] { "QingChenW" });
        meta.description = "Type color codes in Minecraft.";
        meta.credits = "Mojang, FML and Forge";
        meta.url = "https://github.com/DawningW/Allow-Color-Mod";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
    
    @Subscribe
    public void preInit(FMLPreInitializationEvent event) {
        AllowColorEventListener.init(event);
    }
}
