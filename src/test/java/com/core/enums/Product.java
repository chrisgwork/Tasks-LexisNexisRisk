package com.core.enums;

import static com.core.enums.Product.name.*;

public class Product {

    public enum name {
        orangehrm, selenium, automationPractice
    }

    public static String getURL(name product, Test area) {
        String path;

        return switch (product) {
            case orangehrm -> path = (area == Test.UI) ? BaseUrl.UI.getUrl(orangehrm) : BaseUrl.API.getUrl(orangehrm);
            case selenium -> path = (area == Test.UI) ? BaseUrl.UI.getUrl(selenium) : BaseUrl.API.getUrl(selenium);
            case automationPractice -> path = (area == Test.UI) ? BaseUrl.UI.getUrl(automationPractice) : BaseUrl.API.getUrl(automationPractice);
            default -> throw new IllegalArgumentException("Unknown product: " + product);
        };
    }
}
