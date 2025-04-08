package com.common.utils.actions.definitions;


import com.common.utils.actions.drivers.TextElement;
import com.common.utils.actions.drivers.utils.DriverManager;
import com.common.utils.core.authentication.CredentialManager;
import com.common.utils.core.data.helpers.MakeRandom;
import io.cucumber.java.en.Then;

public class ExpectSteps {

    @Then("the class {string} should contain text {string}")
    public void classContainsString(String className, String text) {
        new TextElement(DriverManager.getDriver())
                .inClass(className)
                .byText(text)
                .isVisible();
    }
}