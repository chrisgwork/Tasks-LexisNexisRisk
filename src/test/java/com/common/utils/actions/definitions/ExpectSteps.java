package com.common.utils.actions.definitions;

import com.common.utils.actions.drivers.TextElement;
import com.common.utils.actions.drivers.utils.DriverManager;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ExpectSteps {

    @Then("the {selectorType} {string} {shouldStatus} equal text {string}")
    public void selectorTypeContainsString(String selectorType1, String selector1, String shouldStatus, String selector2) {
        TextElement element = new TextElement(DriverManager.getDriver())
                .by(selectorType1, selector1)
                .by("text", selector2);

        boolean statusValue = switch (shouldStatus) {
            case "should" -> element.isVisible();
            case "should not" -> element.isNotVisible();
            default -> throw new IllegalArgumentException("Unsupported status: " + shouldStatus);
        };

        assertTrue("The input with " + selectorType1 + " '" + selector1 + "' " + shouldStatus + " equal " + selector2, statusValue);
    }
}