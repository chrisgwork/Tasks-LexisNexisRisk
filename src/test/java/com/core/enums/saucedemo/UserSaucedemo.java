package com.core.enums.saucedemo;

import com.core.enums.UserType;

public enum UserSaucedemo implements UserType {
    standard_user,
    locked_out_user,
    problem_user,
    performance_glitch_user,
    error_user,
    visual_user;

    @Override
    public String getUsername() {
        return name();
    }
}
