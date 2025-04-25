package com.core.enums;

import static com.core.enums.Product.name.*;

public class Product {

    public enum name {
        saucedemo, selenium, automationPractice
    }

    public static String getURL(name product, Test area) {
        String path;

        return switch (product) {
            case saucedemo -> path = (area == Test.UI) ? BaseUrl.UI.getUrl(saucedemo) : BaseUrl.API.getUrl(saucedemo);
            case selenium -> path = (area == Test.UI) ? BaseUrl.UI.getUrl(selenium) : BaseUrl.API.getUrl(selenium);
            case automationPractice -> path = (area == Test.UI) ? BaseUrl.UI.getUrl(automationPractice) : BaseUrl.API.getUrl(automationPractice);
            default -> throw new IllegalArgumentException("Unknown product: " + product);
        };
    }
}
