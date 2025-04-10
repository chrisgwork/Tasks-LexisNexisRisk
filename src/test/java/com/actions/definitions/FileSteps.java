package com.actions.definitions;

import com.actions.drivers.File;
import com.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class FileSteps {

    @When("I fill file upload by {selectorType} {string} with file {fileType}")
    public void uploadFileBySelectorType(String selectorType, String name, String fileName) {
        new File(DriverManager.getDriver())
                .by(selectorType, name)
                .upload(fileName);
    }

}