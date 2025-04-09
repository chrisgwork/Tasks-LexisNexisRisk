package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Button;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ButtonSteps {

    @When("I click button by data test id {string}")
    public void clickButtonByDataTestId(String dataTestId) {
        new Button(DriverManager.getDriver())
                .byDataTestId(dataTestId)
                .click();
    }

    @When("I click button by text {string}")
    public void clickButtonByText(String text) {
        new Button(DriverManager.getDriver())
                .byText(text)
                .click();
    }

    @When("I click button in class {string} containing label {string} and data test id {string}")
    public void clickButtonInClassContainingLabelAndDataTestId(String className, String label, String dataTestId) {
        new Button(DriverManager.getDriver())
                .byClass(className)
                .containingLabelAndDataTestId(label, dataTestId, false)
                .click();
    }

    @Then("the button with data test id {string} is visible")
    public void theButtonDataTestIdIsVisible(String dataTestId) {
        boolean isVisible = new Button(DriverManager.getDriver())
                .byDataTestId(dataTestId)
                .isVisible();

        assertTrue("The button with data test id " + dataTestId + " is not visible", isVisible);
    }

    @Then("the button with data test id {string} is not visible")
    public void theButtonDataTestIdIsNotVisible(String dataTestId) {
        boolean isVisible = new Button(DriverManager.getDriver())
                .byDataTestId(dataTestId)
                .isVisible();

        assertFalse("The button with data test id " + dataTestId + " is visible", isVisible);
    }

    @Then("the button in class {string} containing label {string} and data test id {string} is visible")
    public void theButtonInClassContainingLabelAndDataTestIdIsVisible(String className, String label, String dataTestId) {
        boolean isVisible = new Button(DriverManager.getDriver())
                .byClass(className)
                .containingLabelAndDataTestId(label, dataTestId, false)
                .isVisible();

        assertTrue("The button in class " + className + " containing label " + label + " and data test id " + dataTestId + " is not visible", isVisible);
    }
}
