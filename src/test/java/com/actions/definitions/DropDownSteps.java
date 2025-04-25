package com.actions.definitions;

import com.actions.drivers.DropDown;
import com.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class DropDownSteps {

    @When("I fill dropdown box by {selectorType} {string} with option {string}")
    public void selectOptionFromDropDown(String selectorType, String selector, String option) {
        new DropDown(DriverManager.get())
                .by(selectorType, selector)
                .select(option);
    }

    @When("I fill dropdown box by {selectorType} {string} by {selectorType} {string} with option {string}")
    public void selectOptionByFromDropDown(String selectorType1, String selector1, String selectorType2, String selector2, String option) {
        new DropDown(DriverManager.get())
                .by(selectorType1, selector1)
                .by(selectorType2, selector2)
                .select(option);
    }

    @When("I fill dropdown box by {selectorType} {string} with {selectorType} {string} by {selectorType} {string} with option {string}")
    public void selectOptionWithByFromDropDown(String selectorType1, String selector1, String selectorType2, String selector2, String selectorType3, String selector3, String option) {
        new DropDown(DriverManager.get())
                .by(selectorType1, selector1)
                .with(selectorType2, selector2)
                .by(selectorType3, selector3)
                .select(option);
    }
}