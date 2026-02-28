package com.example.mixin.client;

import com.example.gui.CrackedAccountButton;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(at = @At("TAIL"), method = "init")
    private void addCrackedAccountButton(CallbackInfo ci) {
        TitleScreen screen = (TitleScreen) (Object) this;
        new CrackedAccountButton(screen);
    }
}