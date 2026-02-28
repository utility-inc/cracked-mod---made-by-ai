package com.example.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class CrackedAccountCreationScreen extends Screen {
    private final Screen parent;
    private EditBox usernameField;
    
    public CrackedAccountCreationScreen(Screen parent) {
        super(Component.literal("Create Cracked Account"));
        this.parent = parent;
    }
    
    @Override
    protected void init() {
        int fieldWidth = 200;
        int fieldHeight = 20;
        int x = (width - fieldWidth) / 2;
        
        usernameField = new EditBox(font, x, 60, fieldWidth, fieldHeight, Component.literal("Username"));
        usernameField.setMaxLength(16);
        usernameField.setValue("Player");
        addRenderableWidget(usernameField);
        
        addRenderableWidget(Button.builder(
                Component.literal("Create Account"),
                this::onCreateAccount
            ).bounds(x, 90, fieldWidth, fieldHeight).build());
        
        addRenderableWidget(Button.builder(
                Component.literal("Back"),
                this::onBack
            ).bounds(x, 120, fieldWidth, fieldHeight).build());
        
        setInitialFocus(usernameField);
    }
    
    private void onCreateAccount(Button button) {
        String username = usernameField.getValue().trim();
        if (!username.isEmpty()) {
            // Store the cracked account username
            com.example.CrackedAccountManager.setCurrentUsername(username);
            
            // Force Minecraft to use the cracked username
            com.example.CrackedAccountHandler.updatePlayerName();
            
            Minecraft.getInstance().setScreen(new net.minecraft.client.gui.screens.TitleScreen());
        }
    }
    
    private void onBack(Button button) {
        Minecraft.getInstance().setScreen(parent);
    }
}