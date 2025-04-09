package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.CheckBox;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class CheckBoxSteps {

    @When("I {checkState} the checkbox by {selectorType} {string}")
    public void actionCheckBoxById(String checkState, String selectorType, String selector) {

        CheckBox checkBox = new CheckBox(DriverManager.getDriver())
                .by(selectorType, selector);

        if ("check".equals(checkState)) {
            checkBox.check();
            return;
        }
        checkBox.uncheck();
    }

}