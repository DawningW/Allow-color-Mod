package io.github.qingchenw.allowcolor;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.util.StringUtil;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.lang.reflect.Method;

@Mod(AllowColorMod.MODID)
public class AllowColorMod {
    public static final String MODID = "allowcolor";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final char FORMAT_CODE = '\u00A7';

    public AllowColorMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Allow Color Mod has been installed successfully, made by QingChenW.");
        LOGGER.info("Can you input format code? {}", StringUtil_isAllowedChatCharacter(FORMAT_CODE));
    }

    private static boolean StringUtil_isAllowedChatCharacter(char character) {
        // 1.21.9+
        try {
            Method method = StringUtil.class.getDeclaredMethod("isAllowedChatCharacter", int.class);
            return (boolean) method.invoke(null, (int) character);
        } catch (Exception ignored) {}
        // 1.20.5~1.21.8
        try {
            java.lang.reflect.Method method = StringUtil.class.getDeclaredMethod("isAllowedChatCharacter", char.class);
            return (boolean) method.invoke(null, character);
        } catch (Exception ignored) {}
        return false;
    }
}
