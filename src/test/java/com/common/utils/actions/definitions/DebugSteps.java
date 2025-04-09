package com.common.utils.actions.definitions;

import io.cucumber.java.en.And;

public class DebugSteps {

    @And("I wait for {int} seconds")
    public void clickButtonByDataTestId(Integer sleep) throws InterruptedException {
        Thread.sleep(sleep * 1000);
    }
}