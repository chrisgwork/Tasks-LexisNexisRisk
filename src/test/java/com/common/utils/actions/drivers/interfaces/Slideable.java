package com.common.utils.actions.drivers.interfaces;

import com.common.utils.actions.drivers.utils.Driver;
import org.openqa.selenium.WebElement;

public interface Slideable <T extends Driver<T>> {

    default T setRangeValue(String value) {
        return setRangeValue(value, null);
    }

    @SuppressWarnings("unchecked")
    default T setRangeValue(String value, Integer index) {
        if (!(this instanceof Driver<?> driver)) { throw new IllegalStateException("RangeSettable must be a Driver"); }

        driver.waitTillVisible();
        WebElement slider = driver.getElement(index);

        driver.getJsExecutor().executeScript(
                "arguments[0].value = arguments[1]; " +
                "arguments[0].dispatchEvent(new Event('input', { bubbles: true })); " +
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                slider, value
        );

        return (T) driver;
    }
}