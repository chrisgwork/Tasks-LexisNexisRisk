package com.actions.drivers;

import com.actions.drivers.interfaces.Uploadable;
import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class File extends Driver<File> implements Uploadable<File> {

    public File(WebDriver driver) {
        super(driver);
    }

}