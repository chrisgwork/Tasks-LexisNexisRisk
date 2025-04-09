package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Range;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class RangeSteps {

    @When("I set range input by name {string} to value {string}")
    public void setRangeByName(String name, String value) {
        new Range(DriverManager.getDriver())
                .byName(name)
                .setRangeValue(value);
    }

}
