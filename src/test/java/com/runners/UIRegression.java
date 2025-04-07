package com.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/resources/features",
        },
        glue = {
                "com.common.utils.actions.definitions",
                "com.common.hooks",
        },
        plugin = {"pretty", "html:target/cucumber-report.htm"},
        tags = ("@UI and @solo")
)
public class UIRegression extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
