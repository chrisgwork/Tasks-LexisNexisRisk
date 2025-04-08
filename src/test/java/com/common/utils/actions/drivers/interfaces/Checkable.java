package com.common.utils.actions.drivers.interfaces;


import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Checkable<T extends Driver<T>> {

    default T check() {
        return check(null);
    }

    @SuppressWarnings("unchecked")
    default T check(Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("Checkable must be a Driver"); }

        driver.waitTillVisible();
        WebElement checkbox = driver.getElement(index);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        return (T) this;
    }

    default T uncheck() {
        return check(null);
    }

    @SuppressWarnings("unchecked")
    default T uncheck(Integer index) {
        if (!(this instanceof Driver driver)) { throw new IllegalStateException("Checkable must be a Driver"); }

        driver.waitTillVisible();
        WebElement checkbox = driver.getElement(index);
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        return (T) this;
    }
}