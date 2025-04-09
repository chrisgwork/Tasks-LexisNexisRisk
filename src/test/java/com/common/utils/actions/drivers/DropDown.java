package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Selectable;
import com.common.utils.actions.drivers.utils.Driver;
import com.common.utils.actions.drivers.utils.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown extends Driver<DropDown> implements Selectable<DropDown> {

    public DropDown(WebDriver driver) { super(driver); }

}
