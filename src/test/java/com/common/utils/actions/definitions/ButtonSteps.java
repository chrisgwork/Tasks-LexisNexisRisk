package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Button;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ButtonSteps {

    @When("I click button by {selectorType} {string}")
    public void clickButtonByDataTestSelectorType(String selectorType, String dataTestId) {
        new Button(DriverManager.getDriver())
                .by(selectorType, dataTestId)
                .click();
    }

    @Then("the button with {selectorType} {string} {shouldStatus} be visible")
    public void theButtonSelectorTypeVisible(String selectorType, String selector, String shouldStatus) {
        Button element = new Button(DriverManager.getDriver())
                .by(selectorType, selector);

        boolean statusValue = switch (shouldStatus) {
            case "should" -> element.isVisible();
            case "should not" -> element.isNotVisible();
            default -> throw new IllegalArgumentException("Unsupported status: " + shouldStatus);
        };

        assertTrue("The button with " + selectorType + " '" + selector + "' " + shouldStatus + " visible", statusValue);
    }

}
