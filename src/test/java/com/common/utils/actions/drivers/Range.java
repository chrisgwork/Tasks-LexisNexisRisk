package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Slideable;
import com.common.utils.actions.drivers.utils.Driver;
import com.common.utils.actions.drivers.utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Range extends Driver<Range> implements Slideable<Range> {

    public Range(WebDriver driver) {
        super(driver);
    }

}
