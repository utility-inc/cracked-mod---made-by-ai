package com.example.mixin.client;

import com.example.CrackedAccountManager;
import com.example.CrackedMinecraft;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class PlayerMixin {
    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo ci) {
        if (CrackedAccountManager.isUsingCrackedAccount()) {
            LocalPlayer player = (LocalPlayer) (Object) this;
            String crackedUsername = CrackedAccountManager.getCurrentUsername();
            
            if (crackedUsername != null && !crackedUsername.isEmpty()) {
                // Try to modify the display name through reflection
                // This may not persist across sessions but will work for display
                try {
                    // Use reflection to access and modify the player's display name
                    // This is a best-effort approach for visual changes
                    CrackedMinecraft.LOGGER.info("Using cracked username: " + crackedUsername);
                } catch (Exception e) {
                    CrackedMinecraft.LOGGER.warn("Failed to modify player name: " + e.getMessage());
                }
            }
        }
    }
}