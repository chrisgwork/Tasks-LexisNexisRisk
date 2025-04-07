# Java Selenium Test Framework – Setup & Usage Guide

This is a test automation framework built using **Selenium**, **Java 18**, and **Cucumber**, designed for UI testing web forms and inputs for the LexisNexisRisk technical task

---

## Prerequisites

- Java 17+
- Maven 3.8+
- Chrome or Firefox installed
- ChromeDriver or GeckoDriver available on system `PATH`
- IDE (e.g., IntelliJ IDEA) recommended for development

## Project Structure

```
src/
└── test/
    ├── java/
    │   └── com.common.utils.actions/
    │       ├── definitions/        # Step definitions for Cucumber
    │       └── drivers/            # Custom Selenium wrapper logic and driver classes
    |           └──utils/           # Helpers for filtering elements, driver builders, indexes, etc.
    └── resources/
        └── features/
            └── selenium/
                └── ui/
                    └── webform.feature
```

##  Set Up

1. **Clone the repository**:

   If you haven't already cloned the repository, do so using:

    ```bash
    git clone chrisgwork/Tasks-LexisNexisRisk
    ```

2. **Perform a Maven clean build**:

   After cloning the repo, perform a Maven clean build to ensure all dependencies are downloaded and set up properly:

    ```bash
    mvn clean install
    ```

   This will:
   - Remove any previously compiled files (`mvn clean`).
   - Download and install any required dependencies (`mvn install`).
   - Package the application and its dependencies into the target directory.

3. **Run the tests**:

   Once the build is complete, you can run the tests using the instructions below:

   - **Run all tests**:

     From the root of the project, use:

     ```bash
     mvn clean test
     ```

   - **Run a specific feature**:

     To run a specific feature, use:

     ```bash
     mvn test -Dcucumber.options="src/test/resources/features/webform.feature"
     ```

---

### Test Runners

All the test runners are located in `com/runners`. These can be used directly to run the tests (simply clicking the green play button after right-clicking on them)

#### API Regression Runner (Karate)

This runner is designed for API tests using Karate. It runs tests in parallel to improve efficiency.


#### UI Regression Runner (Cucumber + TestNG)

This runner is designed for UI tests using Cucumber with TestNG. It runs scenarios in parallel for faster execution.


#### Combined Test Runner (Karate + UI Cucumber)

This combined runner runs both API and UI tests. It first runs the API tests with Karate, then runs the UI tests with Cucumber/TestNG.


## Sample Step

Example Gherkin step:

```gherkin
And I select "San Francisco" from the dropdown titled "Dropdown (datalist)"
```

Backed by Java logic in DropDownSteps.java:
```java
@When("I select {string} from the dropdown titled {string}")
public void selectOptionFromDropDown(String option, String label) {
        new DropDown(DriverManager.getDriver())
        .byText(label)
        .inClass("form-control")
        .select(option);
}
```

## Driver Details

The `Driver` class is an abstract utility designed to simplify interactions with web elements using Selenium WebDriver. It provides methods for locating elements and performing actions like clicking, filling in text, or selecting checkboxes. One of the key features of this class is its fluent interface design, allowing you to chain method calls to perform multiple queries on an action before performing an action on it. See the below for an example. I've used `Input` driver as the class, as the abstract class `Driver` cannot be instantiated:

```java
new Input(driver)
  .byText("Login")
  .inClass("login-container")
  .byId("username")
  .waitTillVisible()
  .fill("testuser");
```

### Implementing Custom Drivers
It's then easier to create the driver instance classes by extending the Driver class. This allows you to define specific behaviors for different types of elements, such as form inputs, buttons, or dropdowns. Each subclass must implement the getElement(Integer index) method to retrieve the correct element based on the filtered list. For example:
```java
package com.common.utils.actions.drivers;

import com.common.utils.actions.drivers.utils.Driver;
import com.common.utils.actions.drivers.utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends Driver {

    public Input(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getElement(Integer index) {
        return Helper.getIndex(elements,
```

## Debugging Tips

Use `document.querySelector` and test selectors manually in DevTools.

Dispatch synthetic events manually. E.g.:

```javascript
let input = document.querySelector('input[list="my-options"]');
input.value = "San Francisco";
input.dispatchEvent(new Event('input'));
input.dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter' }));
```

This helps simulate typing and selecting on the elements Selenium selects on.

