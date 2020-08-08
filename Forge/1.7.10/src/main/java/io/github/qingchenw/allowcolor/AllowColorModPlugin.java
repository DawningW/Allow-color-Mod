package dawncraft.qingchenw.allowcolor;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.Name;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import java.util.Map;

@IFMLLoadingPlugin.Name("AllowColor")
@IFMLLoadingPlugin.TransformerExclusions({"dawncraft.qingchenw.allowcolor."})
public class AllowColorModPlugin implements IFMLLoadingPlugin
{
  public String[] getASMTransformerClass()
  {
    return new String[] { "dawncraft.qingchenw.allowcolor.AllowColorTransformer" };
  }
  

  public String getModContainerClass()
  {
    return "dawncraft.qingchenw.allowcolor.AllowColorContainer";
  }
  

  public String getSetupClass()
  {
    return null;
  }
  

  public String getAccessTransformerClass()
  {
    return null;
  }
  
  public void injectData(Map<String, Object> data) {}
}
