package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.DropDown;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class DropDownSteps {

    @When("I select dropdown box by text {string} and select option {string}")
    public void selectOptionFromDropDown(String text, String option) {
        new DropDown(DriverManager.getDriver())
                .byText(text)
                .byClass("form-select")
                .select(option);
    }
}