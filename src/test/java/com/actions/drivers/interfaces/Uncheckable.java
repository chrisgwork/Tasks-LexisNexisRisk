package com.actions.drivers.interfaces;

import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Uncheckable<T extends Driver<T>> {

    default T uncheck() {
        return uncheck(null);
    }

    @SuppressWarnings("unchecked")
    default T uncheck(Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Uncheckable must be a Driver"); }

        driver.waitTillVisible();
        driver.waitTillEnabled();
        WebElement element = driver.getElement(index);
        if (element.isSelected()) {
            element.click();
        }

        return (T) driver;
    }

}
