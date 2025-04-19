package com.actions.definitions;

import com.actions.drivers.Navigate;
import com.actions.drivers.utils.DriverManager;
import com.core.enums.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NavigateSteps {

    @Given("I navigate to {string} on product {product}")
    public void iNavigateToOnProduct(String path, Product.name product) {
        new Navigate(DriverManager.getDriver())
                .to(product, path);
    }
    @Given("I navigate to the base path on product {product}")
    public void iNavigateToTheBasePathOnProduct(Product.name product) {
        new Navigate(DriverManager.getDriver())
                .to(product);
    }

    @Then("the URL will contain {string}")
    public void theURLWillContain(String expectedUrlPart) {
        WebDriver driver = DriverManager.getDriver();

        String currentUrl = driver.getCurrentUrl();

        assertTrue("Expected URL to contain: " + expectedUrlPart + " but found: " + currentUrl,
                currentUrl.contains(expectedUrlPart));
    }

    @Then("the URL will not contain {string}")
    public void theURLWillNotContain(String expectedUrlPart) {
        WebDriver driver = DriverManager.getDriver();

        String currentUrl = driver.getCurrentUrl();

        assertFalse("Expected URL to contain: " + expectedUrlPart + " but found: " + currentUrl,
                currentUrl.contains(expectedUrlPart));
    }

}
