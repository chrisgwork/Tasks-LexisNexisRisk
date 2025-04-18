package com.actions.drivers.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Driver<T extends Driver<T>> {

    protected WebDriver driver;

    protected Map<String, String> currentSelector = new HashMap<>();

    public enum SelectorType {CSS, XPATH}

    private static class SelectorMeta {
        SelectorType type;
        Function<String, String> template;

        SelectorMeta(SelectorType type, Function<String, String> template) {
            this.type = type;
            this.template = template;
        }
    }

    private static final Map<String, SelectorMeta> selectorStrategies = Map.of(
        "text",       new SelectorMeta(SelectorType.XPATH, val -> ".//*[contains(normalize-space(.), '" + val + "')]"),
        "class",      new SelectorMeta(SelectorType.CSS,   val -> "." + val.trim().replace(" ", ".")),
        "label",      new SelectorMeta(SelectorType.XPATH, val -> ".//label[text() = '" + val + "']"),
        "name",       new SelectorMeta(SelectorType.CSS,   val -> "[name='" + val + "']"),
        "dataTest",   new SelectorMeta(SelectorType.CSS,   val -> "[data-test='" + val + "']"),
        "id",         new SelectorMeta(SelectorType.CSS,   val -> "[id='" + val + "']")
    );

    protected List<WebElement> elements;

    public Driver(WebDriver driver) {
        this.driver = driver;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public T by(String type, String value) {
        SelectorMeta meta = selectorStrategies.get(type);
        if (meta == null) {
            throw new IllegalArgumentException("Unsupported selector type: " + type);
        }

        String selector = meta.template.apply(value);
        currentSelector.put(meta.type.name(), selector);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = Element.filterBy(meta.type, driver, this.elements, selector);

        return self();
    }

    public T with(String type, String value, Integer matchingElementLimit) {
        SelectorMeta meta = selectorStrategies.get(type);
        if (meta == null) {
            throw new IllegalArgumentException("Unsupported selector type: " + type);
        }

        String selector = meta.template.apply(value);
        currentSelector.put(meta.type.name(), selector);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = Element.withChild(meta.type, driver, this.elements, selector, matchingElementLimit);

        return self();
    }

    public T with(String type, String value) {
        return with(type, value, null);
    }

    public T is(String tagName) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalStateException("No elements available to filter by tag name.");
        }

        this.elements = elements.stream()
                .filter(e -> e.getTagName().equalsIgnoreCase(tagName))
                .collect(Collectors.toList());

        return self();
    }

    public WebElement getElement(Integer index) {
        return Helper.getIndex(elements, index);
    }

    public T waitTillVisible() {
        if (currentSelector == null || currentSelector.isEmpty()) {
            throw new IllegalStateException("currentSelector is not defined.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Map.Entry<String, String> entry = currentSelector.entrySet().iterator().next();
        String selectorType = entry.getKey();
        String selector = entry.getValue();

        switch (selectorType.toUpperCase()) {
            case "XPATH" -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
            case "CSS" -> wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            default -> throw new IllegalArgumentException("Unsupported selector type: " + selectorType);
        }

        return self();
    }

    public T waitTillEnabled() {

        if (currentSelector == null || currentSelector.isEmpty()) {
            throw new IllegalStateException("currentSelector is not defined.");
        }

        Map.Entry<String, String> entry = currentSelector.entrySet().iterator().next();
        String selectorType = entry.getKey();
        String selector = entry.getValue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        switch (selectorType.toUpperCase()) {
            case "XPATH" -> wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
            case "CSS" -> wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
            default -> throw new IllegalArgumentException("Unsupported selector type: " + selectorType);
        }

        return self();
    }

    public JavascriptExecutor getJsExecutor() {
        if (!(driver instanceof JavascriptExecutor)) {
            throw new IllegalStateException("Driver does not support JavaScript execution");
        }
        return (JavascriptExecutor) driver;
    }

    public boolean isVisible(Integer index) {
        return (getElement(index)).isDisplayed();
    }

    public boolean isVisible() {
        return isVisible(null);
    }

    public boolean isNotVisible(Integer index) {
        return !isVisible(index);
    }

    public boolean isNotVisible() {
        return isNotVisible(null);
    }

    public boolean isDisabled(Integer index) {
        return (getElement(index)).getAttribute("disabled") != null;
    }

    public boolean isDisabled() {
        return isDisabled(null);
    }

    public boolean isNotDisabled(Integer index) {
        return !isDisabled(index);
    }

    public boolean isNotDisabled() {
        return isNotDisabled(null);
    }

    public boolean isReadOnly(Integer index) {
        return (getElement(index)).getAttribute("readonly") != null;
    }

    public boolean isReadOnly() {
        return isReadOnly(null);
    }

    public boolean isNotReadOnly(Integer index) {
        return !isReadOnly(index);
    }

    public boolean isNotReadOnly() {
        return isNotReadOnly(null);
    }
}
