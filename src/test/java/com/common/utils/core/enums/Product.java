package com.common.utils.core.enums;

import static com.common.utils.core.enums.Product.name.AUTOMATION_PRACTICE;
import static com.common.utils.core.enums.Product.name.SELENIUM;

public class Product {

    public enum name {
        SELENIUM("selenium"),
        AUTOMATION_PRACTICE("automationPractice");

        private final String name;

        name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static String getURL(name product, TestType area) {
        String path;

        BaseUrl.UI.getUrl(SELENIUM);
        switch (product) {
            case SELENIUM:
                return path = (area == TestType.UI) ? BaseUrl.UI.getUrl(SELENIUM) : BaseUrl.API.getUrl(SELENIUM);
            case AUTOMATION_PRACTICE:
                return  path = (area == TestType.UI) ? BaseUrl.UI.getUrl(AUTOMATION_PRACTICE) : BaseUrl.API.getUrl(AUTOMATION_PRACTICE);
            default:
                throw new IllegalArgumentException("Unknown product: " + product);
        }
    }
}
