package com.actions.drivers;

import com.actions.drivers.interfaces.Selectable;
import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class DropDown extends Driver<DropDown> implements Selectable<DropDown> {

    public DropDown(WebDriver driver) { super(driver); }

}
