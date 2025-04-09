package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Checkable;
import com.common.utils.actions.drivers.interfaces.Toggleable;
import com.common.utils.actions.drivers.interfaces.Uncheckable;
import com.common.utils.actions.drivers.utils.Driver;
import com.common.utils.actions.drivers.utils.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends Driver<CheckBox> implements Checkable<CheckBox>, Uncheckable<CheckBox>, Toggleable<CheckBox> {

    public CheckBox(WebDriver driver) {
        super(driver);
    }

}
