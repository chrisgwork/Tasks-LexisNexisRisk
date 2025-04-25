package com.core.authentication;

import com.actions.drivers.Button;
import com.actions.drivers.Input;
import com.actions.drivers.Navigate;
import com.actions.drivers.utils.DriverManager;
import com.core.enums.Product;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class SessionManager {
    private static final Map<String, SessionState> cachedSessions = new HashMap<>();

    private static class SessionState {
        Set<Cookie> cookies;
        Map<String, String> localStorage;

        SessionState(Set<Cookie> cookies, Map<String, String> localStorage) {
            this.cookies = cookies;
            this.localStorage = localStorage;
        }
    }

    private static String escapeForJs(String input) {
        if (input == null) return "";
        return input
                .replace("\\", "\\\\")
                .replace("'", "\\'")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    public static void set(Product.name product, String username) {
        String sessionKey = generateKey(product, username);
        if (!cachedSessions.containsKey(sessionKey)) {
            performLogin(product, username);
            saveSession(sessionKey);
            return;
        }

        SessionState state = cachedSessions.get(sessionKey);
        boolean sessionExpired = state.cookies.stream()
                .anyMatch(CookieManager::hasExpired);

        if (sessionExpired) {
            performLogin(product, username);
            saveSession(sessionKey);
            return;
        }

        new Navigate(DriverManager.get()).to(product);
        restoreSession(product, sessionKey);
    }

    private static void restoreSession(Product.name product, String sessionKey) {
        SessionState state = cachedSessions.get(sessionKey);

        new Navigate(DriverManager.get()).to(product);

        for (Cookie cookie : state.cookies) {
            DriverManager.get().manage().addCookie(cookie);
        }

        for (Map.Entry<String, String> entry : state.localStorage.entrySet()) {
            String escapedKey = escapeForJs(entry.getKey());
            String escapedValue = escapeForJs(entry.getValue());

            String script = String.format("localStorage.setItem('%s', '%s');", escapedKey, escapedValue);
            ((JavascriptExecutor) DriverManager.get()).executeScript(script);
        }

        DriverManager.get().navigate().refresh();
    }

    private static void saveSession(String sessionKey) {
        Set<Cookie> cookies = DriverManager.get().manage().getCookies();

        Map<String, String> localStorage = (Map<String, String>) ((JavascriptExecutor) DriverManager.get())
                .executeScript(
                        "let items = {}; " +
                                "for (let i = 0; i < localStorage.length; i++) { " +
                                "  let key = localStorage.key(i); " +
                                "  items[key] = localStorage.getItem(key); " +
                                "} return items;"
                );

        cachedSessions.put(sessionKey, new SessionState(cookies, localStorage));
    }

    private static void performLogin(Product.name product, String username) {
        new Navigate(DriverManager.get()).to(product);
        new Input(DriverManager.get()).by("name", "user-name").fill(username);
        new Input(DriverManager.get()).by("name", "password").fill(CredentialManager.getPassword(username));
        new Button(DriverManager.get()).by("name", "login-button").click();
    }

    private static String generateKey(Product.name product, String username) {
        return product.name() + "_" + username;
    }
}
