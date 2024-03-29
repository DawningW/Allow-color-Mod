package io.github.qingchenw.allowcolor;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import net.minecraft.util.ChatAllowedCharacters;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class AllowColorContainer extends DummyModContainer {
    public static final char FORMAT_CODE = '\u00A7';
    
    private static Logger logger;
    
    public AllowColorContainer() {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "allowcolor";
        meta.name = "Allow Color";
        meta.version = "@version@";
        meta.authorList = Arrays.asList("QingChenW");
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
        logger = event.getModLog();
        logger().info("Allow Color Mod has been installed successfully, made by QingChenW.");
        logger().info("Can you input format code? " + ChatAllowedCharacters.isAllowedCharacter(FORMAT_CODE));
    }
    
    public Logger logger() {
        return logger;
    }
}
