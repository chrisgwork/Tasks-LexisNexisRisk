package com.actions.definitions;

import com.actions.drivers.utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DebugSteps {

    private Scenario scenario;

    @And("I wait for {int} seconds")
    public void clickButtonByDataTestId(Integer sleep) throws InterruptedException {
        Thread.sleep(sleep * 1000);
    }

    @Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @And("I take a screenshot")
    public void takeAScreenshot() {
        final byte[] screenshot = ((TakesScreenshot) DriverManager.get())
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Debug Screenshot");
    }

}