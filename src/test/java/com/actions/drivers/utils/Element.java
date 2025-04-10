package com.actions.drivers.utils;

import com.actions.drivers.utils.Driver.SelectorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Element {

    public static List<WebElement> filterBy(SelectorType type, WebDriver driver, List<WebElement> base, String selector) {
        if (base == null || base.isEmpty()) {
            return switch (type) {
                case CSS -> driver.findElements(By.cssSelector(selector));
                case XPATH -> driver.findElements(By.xpath(selector));
            };
        }

        return base.stream()
                .flatMap(e -> switch (type) {
                    case CSS -> e.findElements(By.cssSelector(selector)).stream();
                    case XPATH -> e.findElements(By.xpath(selector)).stream();
                })
                .collect(Collectors.toList());
    }

    public static List<WebElement> withChild(
            SelectorType type,
            WebDriver driver,
            List<WebElement> existingElements,
            String selector,
            Integer elementMatchingLimit
    ) {
        int limit = (elementMatchingLimit == null) ? 1 : elementMatchingLimit;

        if (limit < 0) {
            throw new IllegalArgumentException("Element matching limit: " + limit + " must be >= 0");
        }

        if (existingElements == null || existingElements.isEmpty()) {
            throw new RuntimeException("There are no elements provided, `.with` requires base elements to filter on. Please use `.by` first.");
        }

        List<WebElement> filtered = new ArrayList<>();
        By by = switch (type) {
            case CSS -> By.cssSelector(selector);
            case XPATH -> By.xpath(selector);
        };

        int matchCount = 0;

        for (WebElement element : existingElements) {
            if (limit > 0 && matchCount >= limit) break;

            List<WebElement> children = element.findElements(by);
            if (!children.isEmpty()) {
                filtered.add(element);
                matchCount++;
            }
        }

        return filtered;
    }

    public static List<WebElement> withChild(
            SelectorType type,
            WebDriver driver,
            List<WebElement> existingElements,
            String selector
    ) {
        return withChild(type, driver, existingElements, selector, null);
    }
}
