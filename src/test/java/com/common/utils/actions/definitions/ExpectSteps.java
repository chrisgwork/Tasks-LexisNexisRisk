package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.TextElement;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.Then;

public class ExpectSteps {

    @Then("the {selectorType} {string} should contain {selectorType} {string}")
    public void classContainsString(String selectorType1, String selector1, String selectorType2, String selector2) {
        new TextElement(DriverManager.getDriver())
                .by(selectorType1, selector1)
                .by(selectorType2, selector2)
                .isVisible();
    }
}