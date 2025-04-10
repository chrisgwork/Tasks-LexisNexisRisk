package com.actions.drivers;

import com.actions.drivers.interfaces.Checkable;
import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class RadioButton extends Driver<RadioButton> implements Checkable<RadioButton> {

    public RadioButton(WebDriver driver) {
        super(driver);
    }

}
