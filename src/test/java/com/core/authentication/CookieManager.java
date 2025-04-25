package com.core.authentication;

import org.openqa.selenium.Cookie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CookieManager {

    public static boolean hasExpired(Cookie cookie) {
        String name = cookie.getName();
        if (!name.toLowerCase().contains("session") && !name.toLowerCase().contains("auth")) {
            return false;
        }

        Date expiry = cookie.getExpiry();
        return expiry != null && expiry.getTime() - System.currentTimeMillis() <= 30000;
    }

}