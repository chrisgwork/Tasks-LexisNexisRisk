package com.actions.drivers.interfaces;

import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Checkable<T extends Driver<T>> {

    default T check() {
        return check(null);
    }

    @SuppressWarnings("unchecked")
    default T check(Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Checkable must be a Driver"); }

        driver.waitTillVisible();
        driver.waitTillEnabled();
        WebElement element = driver.getElement(index);
        if (!element.isSelected()) {
            element.click();
        }

        return (T) driver;
    }
}