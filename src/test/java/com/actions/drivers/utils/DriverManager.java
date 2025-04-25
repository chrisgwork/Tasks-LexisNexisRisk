package com.actions.drivers.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void set() {
        if (driver.get() != null) {
            throw new IllegalStateException("Driver is already set for this thread.");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver rawDriver = new ChromeDriver(options);
        WebDriver protectedDriver = ThreadGuard.protect(rawDriver);
        driver.set(protectedDriver);
    }

    public static WebDriver get() {
        WebDriver current = driver.get();
        if (current == null) {
            throw new IllegalStateException("No WebDriver instance found for this thread. Did you forget to call setDriver()?");
        }
        return current;
    }

    public static void quit() {
        WebDriver current = driver.get();
        if (current != null) {
            current.quit();
            driver.remove();
        }
    }
}
