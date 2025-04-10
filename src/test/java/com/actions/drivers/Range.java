package com.actions.drivers;

import com.actions.drivers.interfaces.Slideable;
import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class Range extends Driver<Range> implements Slideable<Range> {

    public Range(WebDriver driver) {
        super(driver);
    }

}
