package com.common.utils.actions.drivers.interfaces;

import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Selectable<T extends Driver<T>> {

    default T select(String optionText) {
        return select(optionText, null);
    }

    @SuppressWarnings("unchecked")
    default T select(String optionText, Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Selectable must be a Driver"); }

        driver.waitTillVisible();
        WebElement input = driver.getElement(index);

        input.sendKeys(optionText);

        input.click();

        return (T) this;
    }

}
