package com.example.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;

public class CrackedAccountButton {
    private final TitleScreen screen;
    
    public CrackedAccountButton(TitleScreen screen) {
        this.screen = screen;
        addButton();
    }
    
    private void addButton() {
        int buttonWidth = 200;
        int buttonHeight = 20;
        int x = (screen.width - buttonWidth) / 2;
        int y = screen.height / 4 + 48 + 72;
        
        Button button = Button.builder(
            Component.literal("Change Account"),
            this::onButtonClick
        ).bounds(x, y, buttonWidth, buttonHeight).build();
        
        // Add button to screen using reflection since addRenderableWidget is protected
        try {
            java.lang.reflect.Method method = screen.getClass().getMethod("addRenderableWidget", 
                net.minecraft.client.gui.components.events.GuiEventListener.class);
            method.invoke(screen, button);
        } catch (Exception e) {
            com.example.CrackedMinecraft.LOGGER.error("Failed to add button to screen: " + e.getMessage());
        }
    }
    
    private void onButtonClick(Button button) {
        Minecraft.getInstance().setScreen(new AccountSelectionScreen(screen));
    }
}