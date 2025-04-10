package com.core.authentication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieManager {

    public static boolean hasExpired(String cookie) {
        String expiresString = extractExpires(cookie);

        if (expiresString != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
                Date expiresDate = sdf.parse(expiresString);

                Date currentDate = new Date();

                long timeDifference = expiresDate.getTime() - currentDate.getTime();

                return timeDifference <= 30000;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static String extractExpires(String cookie) {
        String expiresKeyword = "expires=";
        int expiresIndex = cookie.indexOf(expiresKeyword);

        if (expiresIndex != -1) {
            String expiresPart = cookie.substring(expiresIndex + expiresKeyword.length()).trim();

            int semicolonIndex = expiresPart.indexOf(";");
            if (semicolonIndex != -1) {
                return expiresPart.substring(0, semicolonIndex).trim();
            } else {
                return expiresPart;
            }
        }
        return null;
    }

}