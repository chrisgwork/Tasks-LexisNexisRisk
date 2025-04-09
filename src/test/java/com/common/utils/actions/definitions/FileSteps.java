package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.File;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.When;

public class FileSteps {

    @When("I upload file into input by {selectorType} {string} with file {fileType}")
    public void uploadFileByName(String selectorType, String name, String fileName) {
        new File(DriverManager.getDriver())
                .by(selectorType, name)
                .upload(fileName);
    }

}