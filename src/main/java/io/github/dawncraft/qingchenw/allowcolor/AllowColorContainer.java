package io.github.dawncraft.qingchenw.allowcolor;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class AllowColorContainer extends DummyModContainer
{
	public AllowColorContainer()
	{
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "allowcolor";
		meta.name = "AllowColor";
		meta.version = "1.2";
		meta.authorList = Arrays.asList("QingChenW");
		meta.description = "Type color codes in Minecraft.";
		meta.credits = "Mojang, FML and Forge";
		meta.url = "https://github.com/DawningW/Allow-Color-Mod";
	}
	
    @Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		return true;
	}
    
	@Subscribe
	public void init(FMLInitializationEvent event) {}
}
