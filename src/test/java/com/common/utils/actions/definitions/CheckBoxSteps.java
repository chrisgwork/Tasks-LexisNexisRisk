package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.CheckBox;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;

public class CheckBoxSteps {

    @ParameterType("check|uncheck")
    public String checkState(String type) {
        return type;
    }

    @When("I {checkState} the checkbox by id {string}")
    public void actionCheckBoxById(String checkState, String id) {

        CheckBox checkBox = new CheckBox(DriverManager.getDriver())
                .byId(id);

        if ("check".equals(checkState)) {
            checkBox.check();
            return;
        }
        checkBox.uncheck();
    }

}