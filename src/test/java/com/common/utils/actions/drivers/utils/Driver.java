package com.common.utils.actions.drivers.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Driver<T extends Driver<T>> {

    protected WebDriver driver;
    private String currentSelector = "";
    protected List<WebElement> elements;

    public Driver(WebDriver driver) {
        this.driver = driver;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public T byText(String text) {
        String xpath = "//*[contains(text(), '" + text + "')]";
        this.elements = ElementFilter.filterElementsByXPath(driver, this.elements, xpath);
        return self();
    }

    public T inClass(String containerClass) {
        String selector = "." + containerClass + " ";
        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return self();
    }

    public T byLabel(String labelText) {
        String labelSelector = "//label[text() = 'Dropdown (datalist)']";
        this.elements = ElementFilter.filterElementsByXPath(driver, this.elements, labelSelector);
        return self();
    }

    public T byName(String name) {
        String selector = "[name='" + name + "']";
        this.currentSelector = selector;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return self();
    }

    public T byDataTestId(String dataTestId) {
        String selector = "[data-test='" + dataTestId + "']";
        this.currentSelector = selector;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return self();
    }

    public T byId(String id) {
        String selector = "[id='" + id + "']";
        this.currentSelector = selector;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return self();
    }

    public T containingLabelAndDataTestId(String labelText, String dataTestId, boolean directChildOnly) {
        List<WebElement> matchingElements = new ArrayList<>();

        String selector = directChildOnly
                ? ":scope > [data-test='" + dataTestId + "']"
                : "[data-test='" + dataTestId + "']";

        List<WebElement> containersWithLabel = this.elements.stream()
                .filter(container -> container.getText().contains(labelText))
                .collect(Collectors.toList());

        if (containersWithLabel.isEmpty()) {
            throw new RuntimeException("No container found with label '" + labelText + "'");
        }

        for (WebElement container : containersWithLabel) {
            List<WebElement> matches = ElementFilter.filterElements(driver, List.of(container), selector);
            matchingElements.addAll(matches);
        }

        if (matchingElements.isEmpty()) {
            throw new RuntimeException("No element found with label '" + labelText + "' and data-test '" + dataTestId + "'");
        }

        // Set the filtered elements
        this.elements = matchingElements;
        return self();
    }

    public abstract WebElement getElement(Integer index);

    public T waitTillVisible() {
        if (!currentSelector.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(currentSelector)));
            return self();
        }

        return self();
    }

    public boolean isVisible() {
        return elements != null && !elements.isEmpty() && elements.get(0).isDisplayed();
    }

}
