package com.common.utils.actions.drivers.interfaces;

import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Uncheckable<T extends Driver<T>> {

    default T uncheck() {
        return uncheck(null);
    }

    @SuppressWarnings("unchecked")
    default T uncheck(Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Uncheckable must be a Driver"); }

        driver.waitTillVisible();
        WebElement element = driver.getElement(index);
        if (element.isSelected()) {
            element.click();
        }

        return (T) driver;
    }

}
