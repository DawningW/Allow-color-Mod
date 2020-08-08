package io.github.qingchenw.allowcolor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.SharedConstants;

public class AllowColorMod implements ModInitializer
{
	public static final char FORMAT_CODE = '\u00A7';
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public void onInitialize()
	{
        LOGGER.info("Allow Color Mod has been installed successfully, made by QingChenW");
        LOGGER.info("Can you input format code? " + SharedConstants.isValidChar(FORMAT_CODE));
	}
}
