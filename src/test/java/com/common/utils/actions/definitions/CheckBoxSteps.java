package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.CheckBox;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;

public class CheckBoxSteps {

    @When("I check the checkbox by id {string}")
    public void checkCheckBoxById(String id) {
        new CheckBox(DriverManager.getDriver())
                .byId(id)
                .check();
    }

    @When("I uncheck the checkbox by id {string}")
    public void uncheckCheckBoxById(String id) {
        new CheckBox(DriverManager.getDriver())
                .byId(id)
                .uncheck();
    }

}