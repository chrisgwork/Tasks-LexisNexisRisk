package com.core.enums;

import com.core.enums.orangehrm.UserOrangehrm;
import com.core.enums.selenium.UserSelenium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserRegistry {

    private static final List<UserType> ALL_USERS = Stream.of(
                    UserSelenium.values(),
                    UserOrangehrm.values()
            ).flatMap(Arrays::stream)
            .collect(Collectors.toList());

    public static UserType getUserByName(String name) {
        return ALL_USERS.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown user: " + name));
    }
}
