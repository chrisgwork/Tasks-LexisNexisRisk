package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.utils.Driver;
import com.common.utils.actions.drivers.utils.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends Driver {

    public Input(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getElement(Integer index) {
        return Helper.getIndex(elements, index);
    }

}

