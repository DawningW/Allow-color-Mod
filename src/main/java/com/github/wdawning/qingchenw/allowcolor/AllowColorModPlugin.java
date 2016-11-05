package com.github.wdawning.qingchenw.allowcolor;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("AllowColor")
@IFMLLoadingPlugin.MCVersion("1.8")
@IFMLLoadingPlugin.TransformerExclusions("com.github.wdawning.qingchenw.allowcolor.")
public class AllowColorModPlugin implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass()
	{
	    return new String[]{"com.github.wdawning.qingchenw.allowcolor.AllowColorTransformer"};
	}

	@Override
	public String getModContainerClass()
	{
		return "com.github.wdawning.qingchenw.allowcolor.AllowColorContainer";
	}

	@Override
	public String getSetupClass()
	{
		return null;
	}
	
	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data) {}
}
