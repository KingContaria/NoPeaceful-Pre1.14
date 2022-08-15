package me.voidxwalker.peaceful.mixin;

import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Difficulty.class)
public class DifficultyMixin  {
    @Shadow @Final private static Difficulty[] DIFFICULTIES;

    @Inject(method = "byOrdinal", at = @At("RETURN"),cancellable = true)
    private static void noPeaceful(int ordinal, CallbackInfoReturnable<Difficulty> cir){
        if(cir.getReturnValue().equals(Difficulty.PEACEFUL)){
             cir.setReturnValue(DIFFICULTIES[1]);
        }
    }
}
