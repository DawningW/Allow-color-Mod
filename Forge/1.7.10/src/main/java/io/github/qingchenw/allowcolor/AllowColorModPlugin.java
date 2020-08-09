package io.github.qingchenw.allowcolor;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("AllowColor")
@IFMLLoadingPlugin.TransformerExclusions({ "io.github.qingchenw.allowcolor." })
public class AllowColorModPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[] { "io.github.qingchenw.allowcolor.AllowColorTransformer" };
    }

    @Override
    public String getModContainerClass() {
        return "io.github.qingchenw.allowcolor.AllowColorContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }
}
