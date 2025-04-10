package com.actions.definitions;

import io.cucumber.java.ParameterType;

public class ParamTypes {

    @ParameterType("exampleuser1|exampleuser2")
    public String username(String type) {
        return type;
    }

    @ParameterType("word|postcode")
    public String randomValueType(String type) {
        return type;
    }

    @ParameterType("disabled|readonly")
    public String inputStatus(String type) { return type; }

    @ParameterType("text|class|label|dataTestId|name|id")
    public String selectorType(String type) {
        return type;
    }

    @ParameterType("check|uncheck")
    public String checkStatus(String type) {
        return type;
    }

    @ParameterType("PNG.png|JPG.jpg")
    public String fileType(String type) {
        return type;
    }

    @ParameterType("should|should not")
    public String shouldStatus(String type) {
        return type;
    }

}
