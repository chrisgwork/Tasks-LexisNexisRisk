package com.actions.drivers;

import com.actions.drivers.interfaces.Clickable;
import com.actions.drivers.interfaces.Fillable;
import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class Input extends Driver<Input> implements Clickable<Input>, Fillable<Input> {

    public Input(WebDriver driver) {
        super(driver);
    }

}

