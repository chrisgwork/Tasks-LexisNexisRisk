package com.actions.drivers;

import com.actions.drivers.interfaces.Clickable;
import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class Button extends Driver<Button> implements Clickable<Button> {

    public Button(WebDriver driver) {
        super(driver);
    }

}

