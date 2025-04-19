package com.actions.drivers;

import com.actions.drivers.utils.DriverManager;
import com.core.enums.Product;
import com.core.enums.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Navigate {

    private WebDriver driver;

    public Navigate(WebDriver driver) {
        this.driver = driver;
    }

    public void to(Product.name product, String path) {
        String url = Product.getURL(product, Test.UI);
        driver.get(url + path);

        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }

    public void to(Product.name product) {
        String url = Product.getURL(product, Test.UI);
        driver.get(url);

        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
    }
}
