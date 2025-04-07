package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.Navigate;
import com.common.utils.core.enums.Product;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NavigateSteps {

    @Given("I navigate to {string} on product {string}")
    public void iNavigateToOnProduct(String path, String product) {
        new Navigate(DriverManager.getDriver())
                .to(Product.name.valueOf(product.toUpperCase()), path);
    }
    @Given("I navigate to the base path on product {string}")
    public void iNavigateToTheBasePathOnProduct(String product) {
        new Navigate(DriverManager.getDriver())
                .to(Product.name.valueOf(product.toUpperCase()));
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
