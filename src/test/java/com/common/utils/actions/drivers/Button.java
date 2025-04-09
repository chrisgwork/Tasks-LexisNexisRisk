package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Clickable;
import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class Button extends Driver<Button> implements Clickable<Button> {

    public Button(WebDriver driver) {
        super(driver);
    }

}

