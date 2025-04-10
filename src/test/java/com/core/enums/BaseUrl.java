package com.core.enums;

public enum BaseUrl {

    UI("UI"),
    API("API");

    private final String testType;

    BaseUrl(String testType) {
        this.testType = testType;
    }

    public String getUrl(Product.name product) {
        switch (this) {
            case UI:
                switch (product) {
                    case SELENIUM:
                        return "https://www.selenium.dev";
                    default:
                        throw new IllegalArgumentException("Unknown Product for UI: " + product);
                }
            case API:
                switch (product) {
                    case AUTOMATION_PRACTICE:
                        return "https://automationexercise.com/api";
                    default:
                        throw new IllegalArgumentException("Unknown Product for API: " + product);
                }
            default:
                throw new IllegalArgumentException("Unknown TestType: " + this);
        }
    }

}