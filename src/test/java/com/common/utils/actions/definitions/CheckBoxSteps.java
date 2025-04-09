package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.CheckBox;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class CheckBoxSteps {

    @When("I {checkStatus} the checkbox by {selectorType} {string}")
    public void actionCheckBoxBySelectorType(String checkStatus, String selectorType, String selector) {
        CheckBox checkBox = new CheckBox(DriverManager.getDriver())
                .by(selectorType, selector);

        if ("check".equals(checkStatus)) {
            checkBox.check();
            return;
        }
        checkBox.uncheck();
    }

}