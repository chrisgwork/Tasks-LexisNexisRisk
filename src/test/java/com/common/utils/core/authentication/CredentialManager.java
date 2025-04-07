package com.common.utils.core.authentication;

import io.github.cdimascio.dotenv.Dotenv;

public class CredentialManager {
    private static final Dotenv dotenv = Dotenv.load();
    public static String getPassword(String username) {
        return dotenv.get(username); // Fetch password for the given username
    }
}