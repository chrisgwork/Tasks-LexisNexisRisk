package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Checkable;
import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class RadioButton extends Driver<RadioButton> implements Checkable<RadioButton> {

    public RadioButton(WebDriver driver) {
        super(driver);
    }

}
