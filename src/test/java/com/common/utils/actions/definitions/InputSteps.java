package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Input;
import com.common.utils.actions.drivers.utils.DriverManager;
import com.common.utils.core.authentication.CredentialManager;
import com.common.utils.core.data.helpers.MakeRandom;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;

public class InputSteps {

    @ParameterType("exampleuser1|exampleuser2")
    public String username(String type) {
        return type;
    }

    @ParameterType("word|postcode")
    public String randomValueType(String type) {
        return type;
    }

    @When("I fill input by data test id {string} with text {string}")
    public void fillInputByDataTestId(String dataTestId, String text) {
        new Input(DriverManager.getDriver())
                .byDataTestId(dataTestId)
                .fill(text);
    }

    @When("I fill input by id {string} with text {string}")
    public void fillInputId(String id, String text) {
        new Input(DriverManager.getDriver())
                .byId(id)
                .fill(text);
    }

    @When("I fill input by text {string} with text {string}")
    public void fillInputText(String selector, String text) {
        new Input(DriverManager.getDriver())
                .byText(selector)
                .fill(text);
    }

    @When("I fill input by name {string} with text {string}")
    public void fillInputName(String name, String text) {
        new Input(DriverManager.getDriver())
                .byName(name)
                .fill(text);
    }

    @When("I fill input by data test id {string} for user {string}")
    public void fillInputByDataTestIdPassword(String dataTestId, String username) {
        new Input(DriverManager.getDriver())
                .byDataTestId(dataTestId)
                .fill(CredentialManager.getPassword(username));
    }

    @When("I fill input by name {string} for user {username}")
    public void fillInputByNamePassword(String name, String username) {
        new Input(DriverManager.getDriver())
                .byName(name)
                .fill(CredentialManager.getPassword(username));
    }

    public String randomValueMapper(String randomValue) {
        return switch (randomValue) {
            case "word" -> MakeRandom.word();
            case "postcode" -> MakeRandom.postcode();
            default -> throw new IllegalArgumentException(randomValue + "is not a recognised input");
        };
    }

    @When("I fill input by data test id {string} with random {randomValueType}")
    public void fillInputByDataTestIdWithAValue(String selector, String randomValueType) {

        new Input(DriverManager.getDriver())
                .byDataTestId(selector)
                .fill(randomValueMapper(randomValueType));
    }

    @When("I fill input by name {string} with random {randomValueType}")
    public void fillInputByNameWithAValue(String selector, String randomValueType) {

        new Input(DriverManager.getDriver())
                .byName(selector)
                .fill(randomValueMapper(randomValueType));
    }
}
