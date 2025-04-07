package com.common.utils.core.enums.saucedemo;

public enum UserType {
    STANDARD_USER("standard_user"),
    LOCKED_OUT_USER("locked_out_user"),
    PROBLEM_USER("problem_user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user"),
    ERROR_USER("error_user"),
    VISUAL_USER("visual_user");

    private final String username;

    UserType(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public static UserType fromString(String username) {
        for (UserType type : UserType.values()) {
            if (type.username.equals(username)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid username: " + username);
    }
}