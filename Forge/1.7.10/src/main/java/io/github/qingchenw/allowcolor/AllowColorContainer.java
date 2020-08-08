package dawncraft.qingchenw.allowcolor;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import java.util.Arrays;


public class AllowColorContainer
  extends DummyModContainer
{
  public AllowColorContainer()
  {
    super(new ModMetadata());
    ModMetadata meta = getMetadata();
    meta.modId = "allowcolor";
    meta.name = "AllowColor";
    meta.version = "1.0";
    meta.authorList = Arrays.asList(new String[] { "QingChenW" });
    meta.description = "Type color codes in Minecraft.";
    meta.credits = "Mojang, FML and Forge";
    meta.url = "https://github.com/DawningW/Allow-Color-Mod";
  }
  

  public boolean registerBus(EventBus bus, LoadController controller)
  {
    bus.register(this);
    return true;
  }
  
  @Subscribe
  public void init(FMLInitializationEvent event)
  {
    new AllowColorEvent(event);
  }
}
