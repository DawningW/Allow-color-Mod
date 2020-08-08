package dawncraft.qingchenw.allowcolor;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.PrintStream;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent.Post;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent.Post;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Text;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent.Load;

public class AllowColorEvent
{
  private String version;
  private boolean isLocal;
  
  public AllowColorEvent(FMLInitializationEvent event)
  {
    System.out.println("Gui not support this version: 1.7.10, stop loading gui!");
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  @SubscribeEvent
  public void loadWorld(WorldEvent.Load event)
  {
    Minecraft mc = Minecraft.func_71410_x();
    this.isLocal = (mc.func_71401_C() != null);
    if (!this.isLocal)
    {
      System.out.println("isLocal: " + this.isLocal);
    }
  }
  
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void drawScreenPost(GuiScreenEvent.InitGuiEvent.Post event) {}
  
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void clickButtonPost(GuiScreenEvent.ActionPerformedEvent.Post event) {}
  
  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void TextRender(RenderGameOverlayEvent.Text event) {}
}
