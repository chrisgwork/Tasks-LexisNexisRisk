package com.actions.drivers;

import com.actions.drivers.interfaces.Checkable;
import com.actions.drivers.interfaces.Toggleable;
import com.actions.drivers.interfaces.Uncheckable;
import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class CheckBox extends Driver<CheckBox> implements Checkable<CheckBox>, Uncheckable<CheckBox>, Toggleable<CheckBox> {

    public CheckBox(WebDriver driver) {
        super(driver);
    }

}
