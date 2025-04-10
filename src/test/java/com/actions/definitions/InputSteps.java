package com.actions.definitions;

import com.actions.drivers.Input;
import com.actions.drivers.utils.DriverManager;
import com.core.authentication.CredentialManager;
import com.core.data.helpers.MakeRandom;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;


public class InputSteps {

    @When("I fill input by {selectorType} {string} with text {string}")
    public void fillInputBySelectorType(String selectorType, String selector, String text) {
        new Input(DriverManager.getDriver())
                .by(selectorType, selector)
                .fill(text);
    }

    @When("I fill input by {selectorType} {string} for user {username}")
    public void fillInputByDataTestIdPassword(String selectorType, String selector, String username) {
        new Input(DriverManager.getDriver())
                .by(selectorType, selector)
                .fill(CredentialManager.getPassword(username));
    }

    public String randomValueMapper(String randomValue) {
        return switch (randomValue) {
            case "word" -> MakeRandom.word();
            case "postcode" -> MakeRandom.postcode();
            default -> throw new IllegalArgumentException(randomValue + "is not a recognised input");
        };
    }

    @When("I fill input by {selectorType} {string} with random {randomValueType}")
    public void fillInputByDataTestIdWithAValue(String selectorType, String selector, String randomValueType) {

        new Input(DriverManager.getDriver())
                .by(selectorType, selector)
                .fill(randomValueMapper(randomValueType));
    }

    @When("the input with {selectorType} {string} {shouldStatus} be {inputStatus}")
    public void inputStatus(String selectorType, String selector, String shouldStatus, String inputStatus) {
        Input element = new Input(DriverManager.getDriver())
                .by(selectorType, selector);

        boolean statusValue = switch (inputStatus) {
            case "disabled" -> { yield "should".equals(shouldStatus) ? element.isDisabled() : element.isNotDisabled(); }
            case "readonly" -> { yield "should".equals(shouldStatus) ? element.isReadOnly() : element.isNotReadOnly(); }
            default -> throw new IllegalArgumentException("Unsupported input status: " + inputStatus);
        };

        assertTrue("The input with " + selectorType + " '" + selector + "' " + shouldStatus + " be " + inputStatus, statusValue);
    }
}
