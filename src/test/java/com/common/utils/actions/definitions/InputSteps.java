package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Input;
import com.common.utils.actions.drivers.utils.DriverManager;
import com.common.utils.core.authentication.CredentialManager;
import com.common.utils.core.data.helpers.MakeRandom;
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

    @When("the input with {selectorType} {string} should be {inputStatus}")
    public void inputStatus(String selectorType, String name, String inputStatus) {
        Input element = new Input(DriverManager.getDriver())
                .by(selectorType, name);

        boolean statusValue = switch (inputStatus) {
            case "disabled" -> element.isDisabled();
            case "readonly" -> element.isReadOnly();
            default -> throw new IllegalArgumentException("Unsupported input status: " + inputStatus);
        };

        assertTrue("The input with name " + name + " is " + inputStatus, statusValue);
    }
}
