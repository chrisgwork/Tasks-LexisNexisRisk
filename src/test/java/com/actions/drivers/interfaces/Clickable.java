package com.actions.drivers.interfaces;

import com.actions.drivers.utils.Driver;

public interface Clickable<T extends Driver<T>> {

    default T click() {
        return click(null);
    }

    @SuppressWarnings("unchecked")
    default T click(Integer index) {
        if (!(this instanceof Driver driver)) { throw new IllegalStateException("Clickable must be a Driver"); }

        driver.waitTillVisible();
        driver.waitTillEnabled();
        driver.getElement(index).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return (T) driver;
    }

}