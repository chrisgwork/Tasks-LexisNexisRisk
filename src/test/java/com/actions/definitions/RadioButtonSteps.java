package com.actions.definitions;

import com.actions.drivers.RadioButton;
import com.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class RadioButtonSteps {

    @When("I check the radio button by {selectorType} {string}")
    public void checkRadioButtonById(String selectorType, String selector) {
        new RadioButton(DriverManager.getDriver())
                .by(selectorType, selector)
                .check();
    }

}