package io.github.qingchenw.allowcolor.mixin;

import net.minecraft.util.StringUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StringUtil.class)
public class AllowColorMixin {
    // 1.20.5~1.21.8 : isAllowedChatCharacter(C)Z
    // 1.21.9+       : isAllowedChatCharacter(I)Z
    @Inject(method = "isAllowedChatCharacter", at = @At("HEAD"), cancellable = true)
    private static void isAllowedChatCharacter(@Coerce char character, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(character >= ' ' && character != 127);
    }
}
