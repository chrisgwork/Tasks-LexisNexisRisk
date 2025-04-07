package com.common.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.common.utils.actions.drivers.utils.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        DriverManager.setDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}