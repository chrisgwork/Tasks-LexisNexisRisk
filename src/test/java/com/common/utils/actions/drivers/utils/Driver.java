package com.common.utils.actions.drivers.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Driver<T extends Driver<T>> {

    protected WebDriver driver;

    protected Map<String, String> currentSelector = new HashMap<>();

    protected List<WebElement> elements;

    public Driver(WebDriver driver) {
        this.driver = driver;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public T byText(String text) {
        String selector = "//*[contains(text(), '" + text + "')]";
        currentSelector.put("XPATH", selector);
        this.elements = ElementFilter.filterElementsByXPath(driver, this.elements, selector);
        return self();
    }

    public T byClass(String containerClass) {
        String selector = "." + containerClass + " ";
        currentSelector.put("CSS", selector);
        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return self();
    }

    public T byLabel(String labelText) {
        String selector = "//label[text() = 'Dropdown (datalist)']";
        currentSelector.put("XPATH", selector);
        this.elements = ElementFilter.filterElementsByXPath(driver, this.elements, selector);
        return self();
    }

    public T byName(String name) {
        String selector = "[name='" + name + "']";
        currentSelector.put("CSS", selector);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return self();
    }

    public T byDataTestId(String dataTestId) {
        String selector = "[data-test='" + dataTestId + "']";
        currentSelector.put("CSS", selector);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return self();
    }

    public T byId(String id) {
        String selector = "[id='" + id + "']";
        currentSelector.put("CSS", selector);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
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
            case "XPATH":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
                break;
            case "CSS":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
                break;
            default:
                throw new IllegalArgumentException("Unsupported selector type: " + selectorType);
        }

        return self();
    }

    public boolean isVisible() {
        return elements != null && !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public JavascriptExecutor getJsExecutor() {
        if (!(driver instanceof JavascriptExecutor)) {
            throw new IllegalStateException("Driver does not support JavaScript execution");
        }
        return (JavascriptExecutor) driver;
    }

    public boolean isDisabled() {
        return elements != null && !elements.isEmpty() && elements.get(0).getAttribute("disabled") != null;
    }

    public boolean isReadOnly() {
        return elements != null && !elements.isEmpty() && elements.get(0).getAttribute("readonly") != null;
    }
}
