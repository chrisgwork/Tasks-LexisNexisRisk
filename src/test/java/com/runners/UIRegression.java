package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/resources/features",
        },
        glue = {
                "com.actions.definitions",
                "com.hooks",
        },
        plugin = {"pretty", "html:target/cucumber-report.htm"},
        tags = ("@UI")
)
public class UIRegression extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
