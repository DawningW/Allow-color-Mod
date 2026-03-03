package io.github.qingchenw.allowcolor.mixin;

import net.minecraft.util.StringHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(StringHelper.class)
public abstract class AllowColorMixin
{
    @Overwrite
    public static boolean isValidChar(char c)
    {
        return c >= ' ' && c != 127;
    }
}
