package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.RadioButton;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class RadioButtonSteps {

    @When("I check the radio button by {selectorType} {string}")
    public void checkRadioButtonById(String selectorType, String selector) {
        new RadioButton(DriverManager.getDriver())
                .by(selectorType, selector)
                .check();
    }

}