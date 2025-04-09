package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Button;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ButtonSteps {

    @When("I click button by {selectorType} {string}")
    public void clickButtonByDataTestId(String selectorType, String dataTestId) {
        new Button(DriverManager.getDriver())
                .by(selectorType, dataTestId)
                .click();
    }

    @Then("the button with {selectorType} {string} is visible")
    public void theButtonSelectorTypeVisible(String selectorType, String selector) {
        boolean isVisible = new Button(DriverManager.getDriver())
                .by(selectorType, selector)
                .isVisible();

        assertTrue("The button with " + selectorType + " '" + selector + "' is not visible", isVisible);
    }

    @Then("the button with {selectorType} {string} is not visible")
    public void theButtonDataTestIdIsNotVisible(String selectorType, String selector) {
        boolean isVisible = new Button(DriverManager.getDriver())
                .by(selectorType, selector)
                .isVisible();

        assertFalse("The button with " + selectorType + " '" + selector + "' is visible", isVisible);
    }
}
