package com.actions.definitions;

import com.core.enums.Product;
import com.core.enums.UserRegistry;
import io.cucumber.java.ParameterType;

public class ParamTypes {

    @ParameterType("exampleuser1|exampleuser2|tomsmith")
    public String username(String type) {
        return UserRegistry.getUserByName(type).getUsername();
    }

    @ParameterType("herokuapp|selenium|automationPractice")
    public Product.name product(String type) {
        return Product.name.valueOf(type);
    }

    @ParameterType("word|postcode")
    public String randomValueType(String type) {
        return type;
    }

    @ParameterType("disabled|readonly")
    public String inputStatus(String type) { return type; }

    @ParameterType("text|class|label|dataTest|name|id")
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
