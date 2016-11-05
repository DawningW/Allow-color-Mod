package com.github.wdawning.qingchenw.allowcolor;

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
	public Minecraft mc = Minecraft.getMinecraft();
	private GuiButton[] buttons = {
		new GuiButton(0, 0, 0, "\u00a7"),
		new GuiButton(1, 0, 0, "¡ì00"),
		new GuiButton(2, 0, 0, "¡ì11"),
		new GuiButton(3, 0, 0, "¡ì22"),
		new GuiButton(4, 0, 0, "¡ì33"),
		new GuiButton(5, 0, 0, "¡ì44"),
		new GuiButton(6, 0, 0, "¡ì55"),
		new GuiButton(7, 0, 0, "¡ì66"),
		new GuiButton(8, 0, 0, "¡ì77"),
		new GuiButton(9, 0, 0, "¡ì88"),
		new GuiButton(10, 0, 0, "¡ì99"),
		new GuiButton(11, 0, 0, "¡ìaa"),
		new GuiButton(12, 0, 0, "¡ìbb"),
		new GuiButton(13, 0, 0, "¡ìcc"),
		new GuiButton(14, 0, 0, "¡ìdd"),
		new GuiButton(15, 0, 0, "¡ìee"),
		new GuiButton(16, 0, 0, "¡ìff"),
		new GuiButton(17, 0, 0, "¡ìkk"),
		new GuiButton(18, 0, 0, "¡ìll"),
		new GuiButton(19, 0, 0, "¡ìmm"),
		new GuiButton(20, 0, 0, "¡ìnn"),
		new GuiButton(21, 0, 0, "¡ìoo"),
		new GuiButton(22, 0, 0, "¡ìrr"),
	};
	
    public GuiEventLoader()
    {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void guiScreenShow(InitGuiEvent.Post event)
	{
		if(this.mc.currentScreen instanceof GuiChat)
		{
			GuiScreen screen = event.gui;
			for(int i = 0; i < buttons.length; i++)
			{
				buttons[i].xPosition = 2 + i * 14;
				buttons[i].yPosition = (int)screen.height - 27;
				buttons[i].width = 13;
				buttons[i].height = 11;
				event.buttonList.add(buttons[i]);
			}
		}
	}
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void guiClickButton(ActionPerformedEvent.Post event)
    {
    	for(GuiButton button : buttons)
    	{
    		if(event.button == button)
    		{
    			switch(event.button.id)
    			{
    			case 0: this.mc.currentScreen.setText("\u00a7", false); break;
    			case 1: this.mc.currentScreen.setText("¡ì0", false); break;
    			case 2: this.mc.currentScreen.setText("¡ì1", false); break;
    			case 3: this.mc.currentScreen.setText("¡ì2", false); break;
    			case 4: this.mc.currentScreen.setText("¡ì3", false); break;
    			case 5: this.mc.currentScreen.setText("¡ì4", false); break;
    			case 6: this.mc.currentScreen.setText("¡ì5", false); break;
    			case 7: this.mc.currentScreen.setText("¡ì6", false); break;
    			case 8: this.mc.currentScreen.setText("¡ì7", false); break;
    			case 9: this.mc.currentScreen.setText("¡ì8", false); break;
    			case 10: this.mc.currentScreen.setText("¡ì9", false); break;
    			case 11: this.mc.currentScreen.setText("¡ìa", false); break;
    			case 12: this.mc.currentScreen.setText("¡ìb", false); break;
    			case 13: this.mc.currentScreen.setText("¡ìc", false); break;
    			case 14: this.mc.currentScreen.setText("¡ìd", false); break;
    			case 15: this.mc.currentScreen.setText("¡ìe", false); break;
    			case 16: this.mc.currentScreen.setText("¡ìf", false); break;
    			case 17: this.mc.currentScreen.setText("¡ìk", false); break;
    			case 18: this.mc.currentScreen.setText("¡ìl", false); break;
    			case 19: this.mc.currentScreen.setText("¡ìm", false); break;
    			case 20: this.mc.currentScreen.setText("¡ìn", false); break;
    			case 21: this.mc.currentScreen.setText("¡ìo", false); break;
    			case 22: this.mc.currentScreen.setText("¡ìr", false); break;
    			}
    		}
    	}
    }
    
    /*
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void TextRender(RenderGameOverlayEvent.Text event)
    {
        event.left.add(0, String.format("¡ìaWelcome to use Allow color Mod, ¡ìb%s¡ìc!", mc.thePlayer.getCommandSenderName()));
    }
    */
}
