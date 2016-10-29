package com.github.qingchenw.allowcolor;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

public class AllowColorLoadingPlugin implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass()
	{
	    return new String[]{"com.github.qingchenw.allowcolor.AllowColorTransformer"};
	}

	@Override
	public String getModContainerClass()
	{
		return "com.github.qingchenw.allowcolor.AllowColorModContainer";
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
	public void injectData(Map<String, Object> data)
	{

	}
}
