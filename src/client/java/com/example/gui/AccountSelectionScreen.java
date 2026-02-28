package com.example.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;

public class AccountSelectionScreen extends Screen {
    private final Screen parent;
    
    public AccountSelectionScreen(Screen parent) {
        super(Component.literal("Account Selection"));
        this.parent = parent;
    }
    
    @Override
    protected void init() {
        int buttonWidth = 200;
        int buttonHeight = 20;
        int x = (width - buttonWidth) / 2;
        
        addRenderableWidget(Button.builder(
                Component.literal("Create Cracked Account"),
                this::onCreateCrackedAccount
            ).bounds(x, 60, buttonWidth, buttonHeight).build());
        
        addRenderableWidget(Button.builder(
                Component.literal("Switch to Java Account"),
                this::onSwitchToJavaAccount
            ).bounds(x, 90, buttonWidth, buttonHeight).build());
        
        addRenderableWidget(Button.builder(
                Component.literal("Back"),
                this::onBack
            ).bounds(x, 120, buttonWidth, buttonHeight).build());
    }
    
    private void onCreateCrackedAccount(Button button) {
        Minecraft.getInstance().setScreen(new CrackedAccountCreationScreen(this));
    }
    
    private void onSwitchToJavaAccount(Button button) {
        // Switch back to Java authentication
        Minecraft.getInstance().setScreen(new TitleScreen());
    }
    
    private void onBack(Button button) {
        Minecraft.getInstance().setScreen(parent);
    }
}