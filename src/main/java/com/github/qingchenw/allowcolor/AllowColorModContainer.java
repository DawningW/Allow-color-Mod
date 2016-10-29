package com.github.qingchenw.allowcolor;

import java.util.Arrays;

import com.google.common.eventbus.Subscribe;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;

public class AllowColorModContainer extends DummyModContainer
{
	public AllowColorModContainer()
	{
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "allowcolor";
		meta.name = "AllowColor";
		meta.version = "1.0";
		meta.authorList = Arrays.asList("QingChenW");
		meta.description = "Type color codes in Minecraft.";
		meta.credits = "Mojang, FML and Forge";
		meta.url = "http://github.com/DawningW/Allow-Color-Mod";
	}
	
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		return true;
	}
	
	@Subscribe
	public void init(FMLInitializationEvent event)
	{
		new GuiEventLoader();
	}
}
