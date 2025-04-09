package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Clickable;
import com.common.utils.actions.drivers.interfaces.Fillable;
import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class Input extends Driver<Input> implements Clickable<Input>, Fillable<Input> {

    public Input(WebDriver driver) {
        super(driver);
    }

}

