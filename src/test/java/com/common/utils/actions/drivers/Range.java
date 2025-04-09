package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Slideable;
import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class Range extends Driver<Range> implements Slideable<Range> {

    public Range(WebDriver driver) {
        super(driver);
    }

}
