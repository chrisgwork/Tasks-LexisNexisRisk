package com.actions.definitions;

import com.actions.drivers.DropDown;
import com.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class DropDownSteps {

    @When("I fill dropdown box by {selectorType} {string} with option {string}")
    public void selectOptionFromDropDown(String selectorType, String text, String option) {
        new DropDown(DriverManager.getDriver())
                .by(selectorType, text)
                .by("class","form-select")
                .select(option);
    }
}