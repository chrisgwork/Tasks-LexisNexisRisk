package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.DropDown;
import com.common.utils.actions.drivers.utils.DriverManager;
import com.common.utils.core.authentication.CredentialManager;
import com.common.utils.core.data.helpers.MakeRandom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class DropDownSteps {

    @When("I select {string} from the dropdown titled {string}")
    public void selectOptionFromDropDown(String option, String label) {
        new DropDown(DriverManager.getDriver())
                .byText(label)
                .inClass("form-control")
                .select(option);
    }
}