package com.common.utils.actions.drivers.interfaces;

import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Toggleable<T extends Driver<T>> {

    default T toggle() {
        return toggle(null);
    }

    @SuppressWarnings("unchecked")
    default T toggle(Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Toggleable must be a Driver"); }

        driver.waitTillVisible();
        driver.getElement(index).click();
        return (T) driver;
    }
}
