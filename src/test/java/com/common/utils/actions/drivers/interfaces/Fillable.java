package com.common.utils.actions.drivers.interfaces;

import com.common.utils.actions.drivers.utils.Driver;

public interface Fillable<T extends Driver<T>> {

    default T fill(String text) {
        return fill(text, null);
    }

    @SuppressWarnings("unchecked")
    default T fill(String text, Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Fillable must be a Driver"); }

        driver.waitTillVisible();
        driver.getElement(index).sendKeys(text);

        return (T) driver;
    }

}
