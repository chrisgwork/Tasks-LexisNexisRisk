package com.core.enums;

public enum BaseUrl {

    UI("UI"),
    API("API");

    BaseUrl(String testType) {
    }

    public String getUrl(Product.name product) {
        switch (this) {
            case UI -> {
                return switch (product) {
                    case herokuapp -> "https://the-internet.herokuapp.com";
                    case selenium -> "https://www.selenium.dev/selenium/web";
                    default -> throw new IllegalArgumentException("Unknown Product for UI: " + product);
                };
            }
            case API -> {
                return switch (product) {
                    case automationPractice -> "https://automationexercise.com/api";
                    default -> throw new IllegalArgumentException("Unknown Product for API: " + product);
                };
            }
            default -> throw new IllegalArgumentException("Unknown TestType: " + this);
        }
    }
}