package com.hooks;

import com.actions.drivers.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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