package com.common.utils.actions.drivers.interfaces;

import com.common.utils.actions.drivers.utils.Driver;

public interface Clickable<T extends Driver<T>> {

    default T click() {
        return click(null);
    }

    @SuppressWarnings("unchecked")
    default T click(Integer index) {
        if (!(this instanceof Driver driver)) { throw new IllegalStateException("Clickable must be a Driver"); }

        driver.waitTillVisible();
        driver.getElement(index).click();

        return (T) this;
    }
}