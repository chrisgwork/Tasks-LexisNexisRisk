package com.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullRegression {

    @Test
    void runApiTests() {
        Results results = Runner.path("classpath:features")
                .tags("@API")
                .parallel(10);

        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    @CucumberOptions(
            features = {
                    "src/test/resources/features/saucedemo/ui",
            },
            glue = {
                    "com.actions.definitions",
                    "com.hooks",
            },
            plugin = {"pretty", "html:target/cucumber-report.htm"},
            tags = "@ui"
    )
    public static class UIRegression extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }

    @Test
    void runUiTests() {
        org.testng.TestNG testNG = new org.testng.TestNG();
        testNG.setTestClasses(new Class[]{UIRegression.class});
        testNG.run();
    }
}
