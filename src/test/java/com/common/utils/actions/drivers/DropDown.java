package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.interfaces.Selectable;
import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebDriver;

public class DropDown extends Driver<DropDown> implements Selectable<DropDown> {

    public DropDown(WebDriver driver) { super(driver); }

}
