package com.github.qingchenw.allowcolor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiEventLoader extends Gui
{
	//register
    public GuiEventLoader()
    {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }
    /*
	public Minecraft mc = Minecraft.getMinecraft();
	private GuiButton button1 = new GuiButton(0, 0, 0, "\u00a7");
	
	
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void PreGUIRender(RenderGameOverlayEvent.Pre event)
    {
    	int width = event.resolution.getScaledWidth();
    	int height = event.resolution.getScaledHeight();
    	
        if (event.type == ElementType.CHAT)
        {
        	button1.xPosition = 0;
        	button1.yPosition = (int)(height * 0.4);
        	button1.width = 50;
    		this.buttonList.add(button1);
        }
    }
    
    @SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void guiScreenShow(InitGuiEvent.Post event)
	{
		if(this.mc.currentScreen instanceof GuiChat)
		{
			GuiScreen screen = event.gui;

			button1.xPosition = 0;
			button1.yPosition = (int)(screen.height * 0.4);
			button1.width = 50;
			event.buttonList.add(button1);
		}
	}
	
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void guiClickButton(ActionPerformedEvent.Post event)
    {
    	if(event.button == button1)
    	{
    		//currentScreen
            this.mc.currentScreen.setText("\u00a7", false);
    	}
    }
    */
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void TextRender(RenderGameOverlayEvent.Text event)
    {
        event.left.add(0, String.format("¡ìaWelcome to use Allow color Mod, ¡ìb%s¡ìc!"));
    }
}
