package com.common.utils.actions.drivers.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Driver {

    protected WebDriver driver;
    private String currentSelector = "";
    protected List<WebElement> elements;

    public Driver(WebDriver driver) {
        this.driver = driver;
    }

    public Driver byText(String text) {
        String xpath = "//*[contains(text(), '" + text + "')]";
        this.elements = ElementFilter.filterElementsByXPath(driver, this.elements, xpath);
        return this;
    }

    public Driver inClass(String containerClass) {
        String selector = "." + containerClass + " ";
        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return this;
    }

    public Driver byLabel(String labelText) {
        String labelSelector = "//label[text() = 'Dropdown (datalist)']";
        this.elements = ElementFilter.filterElementsByXPath(driver, this.elements, labelSelector);
        return this;
    }

    public Driver byName(String name) {
        String selector = "[name='" + name + "']";
        this.currentSelector = selector;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return this;
    }

    public Driver byDataTestId(String dataTestId) {
        String selector = "[data-test='" + dataTestId + "']";
        this.currentSelector = selector;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return this;
    }

    public Driver byId(String id) {
        String selector = "[id='" + id + "']";
        this.currentSelector = selector;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        this.elements = ElementFilter.filterElements(driver, this.elements, selector);
        return this;
    }

    public Driver containingLabelAndDataTestId(String labelText, String dataTestId, boolean directChildOnly) {
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
        return this;
    }

    public abstract WebElement getElement(Integer index);

    public Driver waitTillVisible() {
        if (!currentSelector.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(currentSelector)));
            return this;
        }

        return this;
    }

    public boolean isVisible() {
        return elements != null && !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public void select(String optionText, Integer index) {
        waitTillVisible();
        if (index == null) { index = 0; }

        WebElement input = getElement(index);

        input.sendKeys(optionText);

        input.click();
    }

    public void select(String optionText) {
        this.select(optionText, null);
    }

    public void check(Integer index) {
        waitTillVisible();
        WebElement checkbox = getElement(index);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void check() {
        waitTillVisible();
        WebElement checkbox = getElement(0);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheck(Integer index) {
        waitTillVisible();
        WebElement checkbox = getElement(index);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheck() {
        waitTillVisible();
        WebElement checkbox = getElement(0);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void click(Integer index) {
        waitTillVisible();
        getElement(index).click();
    }

    public void click() {
        waitTillVisible();
        getElement(0).click();
    }

    public void fill(String text, Integer index) {
        waitTillVisible();
        getElement(index).sendKeys(text);
    }

    public void fill(String text) {
        waitTillVisible();
        getElement(0).sendKeys(text);
    }
}
