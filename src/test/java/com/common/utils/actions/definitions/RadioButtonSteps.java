package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.RadioButton;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;

public class RadioButtonSteps {

    @When("I check the radio button by id {string}")
    public void checkRadioButtonById(String id) {
        new RadioButton(DriverManager.getDriver())
                .byId(id)
                .check();
    }

}