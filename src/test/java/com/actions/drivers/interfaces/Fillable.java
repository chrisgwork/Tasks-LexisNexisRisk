package com.actions.drivers.interfaces;

import com.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Fillable<T extends Driver<T>> {

    default T fill(String text) {
        return fill(text, null);
    }

    @SuppressWarnings("unchecked")
    default T fill(String text, Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Fillable must be a Driver"); }

        driver.waitTillVisible();
        driver.waitTillEnabled();
        WebElement input = driver.getElement(index);
        input.sendKeys(text);
        input.click();

        return (T) driver;
    }

}
