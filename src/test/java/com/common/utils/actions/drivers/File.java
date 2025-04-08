package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Uploadable;
import com.common.utils.actions.drivers.utils.Driver;
import com.common.utils.actions.drivers.utils.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class File extends Driver<File> implements Uploadable<File> {

    public File(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getElement(Integer index) {
        return Helper.getIndex(elements, index);
    }

}