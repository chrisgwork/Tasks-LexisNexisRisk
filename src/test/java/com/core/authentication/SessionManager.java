package com.core.authentication;

import com.actions.drivers.Button;
import com.actions.drivers.Input;
import com.actions.drivers.Navigate;
import com.actions.drivers.utils.DriverManager;
import com.core.enums.Product;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class SessionManager {
    private static final Map<String, SessionState> cachedSessions = new HashMap<>();

    private final WebDriver driver;
    private Product.name product;
    private String username;

    public SessionManager(WebDriver driver) {
        this.driver = driver;
    }

    private static class SessionState {
        Set<Cookie> cookies;
        Map<String, String> localStorage;

        SessionState(Set<Cookie> cookies, Map<String, String> localStorage) {
            this.cookies = cookies;
            this.localStorage = localStorage;
        }
    }

    private String escapeForJs(String input) {
        if (input == null) return "";
        return input
                .replace("\\", "\\\\")
                .replace("'", "\\'")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    public void set(Product.name product, String username) {
        this.product = product;
        this.username = username;

        String sessionKey = generateKey();
        if (!cachedSessions.containsKey(sessionKey)) {
            performLogin();
            saveSession(sessionKey);
            return;
        }

        SessionState state = cachedSessions.get(sessionKey);
        boolean sessionExpired = state.cookies.stream()
                .anyMatch(CookieManager::hasExpired);

        if (sessionExpired) {
            performLogin();
            saveSession(sessionKey);
            return;
        }

        restoreSession(sessionKey);
    }

    private void restoreSession(String sessionKey) {
        SessionState state = cachedSessions.get(sessionKey);

        new Navigate(driver).to(product);

        for (Cookie cookie : state.cookies) {
            driver.manage().addCookie(cookie);
        }

        for (Map.Entry<String, String> entry : state.localStorage.entrySet()) {
            String escapedKey = escapeForJs(entry.getKey());
            String escapedValue = escapeForJs(entry.getValue());

            String script = String.format("localStorage.setItem('%s', '%s');", escapedKey, escapedValue);
            ((JavascriptExecutor) driver).executeScript(script);
        }

        driver.navigate().refresh();
    }

    private void saveSession(String sessionKey) {
        Set<Cookie> cookies = driver.manage().getCookies();

        Map<String, String> localStorage = (Map<String, String>) ((JavascriptExecutor) driver)
                .executeScript(
                        "let items = {}; " +
                                "for (let i = 0; i < localStorage.length; i++) { " +
                                "  let key = localStorage.key(i); " +
                                "  items[key] = localStorage.getItem(key); " +
                                "} return items;"
                );

        cachedSessions.put(sessionKey, new SessionState(cookies, localStorage));
    }

    private void performLogin() {
        new Navigate(driver).to(product);
        new Input(driver).by("name", "user-name").fill(username);
        new Input(driver).by("name", "password").fill(CredentialManager.getPassword(username));
        new Button(driver).by("name", "login-button").click();
    }

    private String generateKey() {
        return product.name() + "_" + username;
    }
}
