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
		new GuiButton(1, 0, 0, "§00"),
		new GuiButton(2, 0, 0, "§11"),
		new GuiButton(3, 0, 0, "§22"),
		new GuiButton(4, 0, 0, "§33"),
		new GuiButton(5, 0, 0, "§44"),
		new GuiButton(6, 0, 0, "§55"),
		new GuiButton(7, 0, 0, "§66"),
		new GuiButton(8, 0, 0, "§77"),
		new GuiButton(9, 0, 0, "§88"),
		new GuiButton(10, 0, 0, "§99"),
		new GuiButton(11, 0, 0, "§aa"),
		new GuiButton(12, 0, 0, "§bb"),
		new GuiButton(13, 0, 0, "§cc"),
		new GuiButton(14, 0, 0, "§dd"),
		new GuiButton(15, 0, 0, "§ee"),
		new GuiButton(16, 0, 0, "§ff"),
		new GuiButton(17, 0, 0, "§kk"),
		new GuiButton(18, 0, 0, "§ll"),
		new GuiButton(19, 0, 0, "§mm"),
		new GuiButton(20, 0, 0, "§nn"),
		new GuiButton(21, 0, 0, "§oo"),
		new GuiButton(22, 0, 0, "§rr"),
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
				buttons[i].yPosition = (int)screen.height - 26;
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
    			case 1: this.mc.currentScreen.setText("§0", false); break;
    			case 2: this.mc.currentScreen.setText("§1", false); break;
    			case 3: this.mc.currentScreen.setText("§2", false); break;
    			case 4: this.mc.currentScreen.setText("§3", false); break;
    			case 5: this.mc.currentScreen.setText("§4", false); break;
    			case 6: this.mc.currentScreen.setText("§5", false); break;
    			case 7: this.mc.currentScreen.setText("§6", false); break;
    			case 8: this.mc.currentScreen.setText("§7", false); break;
    			case 9: this.mc.currentScreen.setText("§8", false); break;
    			case 10: this.mc.currentScreen.setText("§9", false); break;
    			case 11: this.mc.currentScreen.setText("§a", false); break;
    			case 12: this.mc.currentScreen.setText("§b", false); break;
    			case 13: this.mc.currentScreen.setText("§c", false); break;
    			case 14: this.mc.currentScreen.setText("§d", false); break;
    			case 15: this.mc.currentScreen.setText("§e", false); break;
    			case 16: this.mc.currentScreen.setText("§f", false); break;
    			case 17: this.mc.currentScreen.setText("§k", false); break;
    			case 18: this.mc.currentScreen.setText("§l", false); break;
    			case 19: this.mc.currentScreen.setText("§m", false); break;
    			case 20: this.mc.currentScreen.setText("§n", false); break;
    			case 21: this.mc.currentScreen.setText("§o", false); break;
    			case 22: this.mc.currentScreen.setText("§r", false); break;
    			}
    		}
    	}
    }
    
    /*
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void TextRender(RenderGameOverlayEvent.Text event)
    {
        event.left.add(0, String.format("§aWelcome to use Allow color Mod, §b%s§c!", mc.thePlayer.getCommandSenderName()));
    }
    */
}
