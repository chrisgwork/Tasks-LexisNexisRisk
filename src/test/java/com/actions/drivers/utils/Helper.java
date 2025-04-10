package com.actions.drivers.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Helper {

    /**
     * Gets an element from a list based on index:
     * - null = first
     * - -1 = last
     * - N = nth (0-based)
     */
    public static WebElement getIndex(List<WebElement> elements, Integer index) {
        if (elements.isEmpty()) { throw new RuntimeException("No element found."); }

        if (index == null) {
            return elements.get(0);
        } else if (index == -1) {
            return elements.get(elements.size() - 1);
        } else {
            if (index >= elements.size()) {
                throw new IndexOutOfBoundsException("Index " + index + " out of range for element list.");
            }
            return elements.get(index);
        }
    }

}
