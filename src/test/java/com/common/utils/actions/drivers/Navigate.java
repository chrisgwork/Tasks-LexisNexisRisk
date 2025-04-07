package com.common.utils.actions.drivers;

import com.common.utils.core.enums.Product;
import com.common.utils.core.enums.TestType;
import org.openqa.selenium.WebDriver;

public class Navigate {

    private WebDriver driver;

    public Navigate(WebDriver driver) {
        this.driver = driver;
    }

    public void to(Product.name product, String path) {
        String url = Product.getURL(product, TestType.UI);
        driver.get(url + path);
    }

    public void to(Product.name product) {
        String url = Product.getURL(product, TestType.UI);
        driver.get(url);
    }
}
