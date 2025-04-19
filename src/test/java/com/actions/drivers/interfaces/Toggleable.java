package com.actions.drivers.interfaces;

import com.actions.drivers.utils.Driver;

public interface Toggleable<T extends Driver<T>> {

    default T toggle() {
        return toggle(null);
    }

    @SuppressWarnings("unchecked")
    default T toggle(Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Toggleable must be a Driver"); }

        driver.waitTillVisible();
        driver.waitTillEnabled();
        driver.getElement(index).click();
        return (T) driver;
    }
}
