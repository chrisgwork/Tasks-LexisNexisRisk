package com.common.utils.actions.drivers.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElementFilter {

    public static List<WebElement> filterElementsByXPath(WebDriver driver, List<WebElement> base, String xpath) {
        if (base == null || base.isEmpty()) {
            return driver.findElements(By.xpath(xpath));
        }

        List<WebElement> filtered = new ArrayList<>();
        for (WebElement element : base) {
            filtered.addAll(element.findElements(By.xpath(xpath)));
        }

        return filtered;
    }

    public static List<WebElement> filterElements(WebDriver driver, List<WebElement> existingElements, String selector) {
        if (existingElements == null || existingElements.isEmpty()) {
            return driver.findElements(By.cssSelector(selector));
        } else {
            return existingElements.stream()
                    .flatMap(e -> e.findElements(By.cssSelector(selector)).stream())
                    .collect(Collectors.toList());
        }
    }
}
