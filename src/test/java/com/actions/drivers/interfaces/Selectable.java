package com.actions.drivers.interfaces;

import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface Selectable<T extends Driver<T>> {

    default T select(String visibleText) {
        return select(visibleText, null);
    }

    @SuppressWarnings("unchecked")
    default T select(String visibleText, Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Selectable must be a Driver"); }

        driver.waitTillVisible();
        driver.waitTillEnabled();
        WebElement dropdown = driver.getElement(index);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);

        return (T) driver;
    }

}
