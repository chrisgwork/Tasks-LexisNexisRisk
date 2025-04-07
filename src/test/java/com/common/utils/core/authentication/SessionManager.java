package com.common.utils.core.authentication;

import com.common.utils.actions.drivers.Button;
import com.common.utils.actions.drivers.Input;
import com.common.utils.actions.drivers.Navigate;
import com.common.utils.core.enums.Product;
import com.common.utils.actions.drivers.utils.DriverManager;
import org.openqa.selenium.Cookie;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class SessionManager {
    private static final Map<String, Set<Cookie>> cachedSessions = new HashMap<>();

    public static void set(String product, String username) {

        String sessionKey = generateKey(product, username);

        if (!cachedSessions.containsKey(sessionKey)) {
            performLogin(product, username);
            saveSession(sessionKey);
            return;
        }

        Set<Cookie> cookies = cachedSessions.get(sessionKey);
        boolean sessionExpired = cookies.stream()
                .anyMatch(cookie -> CookieManager.hasExpired(String.valueOf(cookie)));

        if (sessionExpired) {
            performLogin(product, username);
            saveSession(sessionKey);
            return;
        }

        new Navigate(DriverManager.getDriver()).to(Product.name.valueOf(product.toUpperCase()));
        restoreSession(sessionKey);
    }

    private static void restoreSession(String sessionKey) {
        Set<Cookie> cookies = cachedSessions.get(sessionKey);
        for (Cookie cookie : cookies) {
            DriverManager.getDriver().manage().addCookie(cookie);
        }
        DriverManager.getDriver().navigate().refresh();
    }

    private static void saveSession(String sessionKey) {
        cachedSessions.put(sessionKey, DriverManager.getDriver().manage().getCookies());
    }

    private static void performLogin(String product, String username) {
        new Navigate(DriverManager.getDriver()).to(Product.name.valueOf(product.toUpperCase()));
        new Input(DriverManager.getDriver()).byDataTestId("username").fill(username);
        new Input(DriverManager.getDriver()).byDataTestId("password").fill(CredentialManager.getPassword(username));
        new Button(DriverManager.getDriver()).byDataTestId("login-button").click();
    }

    private static String generateKey(String product, String username) {
        return product.toLowerCase() + "_" + username.toLowerCase();
    }
}
