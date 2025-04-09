package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.File;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;

public class FileSteps {

    @ParameterType("PNG.png|JPG.jpg")
    public String fileType(String type) {
        return type;
    }

    @When("I upload file into input by name {string} with file {fileType}")
    public void uploadFileByName(String name, String fileName) {
        new File(DriverManager.getDriver())
                .byName(name)
                .upload(fileName);
    }

}