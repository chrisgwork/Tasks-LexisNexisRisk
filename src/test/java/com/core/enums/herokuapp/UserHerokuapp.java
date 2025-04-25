package com.core.enums.herokuapp;

import com.core.enums.UserType;

public enum UserHerokuapp implements UserType {
    tomsmith;

    @Override
    public String getUsername() {
        return name();
    }
}
