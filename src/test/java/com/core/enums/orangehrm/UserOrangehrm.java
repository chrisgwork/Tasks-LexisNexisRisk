package com.core.enums.orangehrm;

import com.core.enums.UserType;

public enum UserOrangehrm implements UserType {
    Admin;

    @Override
    public String getUsername() {
        return name();
    }
}
