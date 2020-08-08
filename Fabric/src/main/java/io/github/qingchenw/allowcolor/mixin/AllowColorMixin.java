package io.github.qingchenw.allowcolor.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SharedConstants.class)
public abstract class AllowColorMixin
{
	@Overwrite
	public static boolean isValidChar(char c)
	{
		return c >= ' ' && c != 127;
	}
	
	/*
	@Inject(method = "isValidChar(C)Z", at = @At("HEAD"))
	private static void isValidChar(char c, CallbackInfoReturnable<Boolean> info)
	{
		if (c >= ' ' && c != 127)
		{
			info.setReturnValue(true);
		}
	}
	*/
}
