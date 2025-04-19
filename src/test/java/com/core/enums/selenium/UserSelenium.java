package com.core.enums.selenium;

import com.core.enums.UserType;

public enum UserSelenium implements UserType {
    exampleuser1,
    exampleuser2;

    @Override
    public String getUsername() {
        return name();
    }
}
