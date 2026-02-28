package com.example;

public class CrackedAccountManager {
    private static String currentUsername = "Player";
    
    public static String getCurrentUsername() {
        return currentUsername;
    }
    
    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }
    
    public static boolean isUsingCrackedAccount() {
        return currentUsername != null && !currentUsername.equals("Player");
    }
}