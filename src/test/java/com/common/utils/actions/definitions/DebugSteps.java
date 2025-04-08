package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Button;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.And;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DebugSteps {

    @And("I wait for {int} seconds")
    public void clickButtonByDataTestId(Integer sleep) throws InterruptedException {
        Thread.sleep(sleep * 1000);
    }
}