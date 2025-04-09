package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Uploadable;
import com.common.utils.actions.drivers.utils.Driver;

import org.openqa.selenium.WebDriver;

public class File extends Driver<File> implements Uploadable<File> {

    public File(WebDriver driver) {
        super(driver);
    }

}