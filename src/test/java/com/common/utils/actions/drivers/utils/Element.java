package com.common.utils.actions.drivers.utils;

import com.common.utils.actions.drivers.utils.Driver.SelectorType;
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

    public static List<WebElement> withChild(SelectorType type, WebDriver driver, List<WebElement> existingElements, String selector) {
        if (existingElements == null || existingElements.isEmpty()) {
            return switch (type) {
                case CSS -> driver.findElements(By.cssSelector(selector));
                case XPATH -> driver.findElements(By.xpath(selector));
            };
        }

        List<WebElement> filtered = new ArrayList<>();

        for (WebElement element : existingElements) {
            List<WebElement> children = switch (type) {
                case CSS -> element.findElements(By.cssSelector(selector));
                case XPATH -> element.findElements(By.xpath(selector));
            };

            if (!children.isEmpty()) {
                filtered.add(element);
            }
        }

        return filtered;
    }
}
