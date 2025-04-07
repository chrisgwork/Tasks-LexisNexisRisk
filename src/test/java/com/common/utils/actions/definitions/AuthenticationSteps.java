package com.common.utils.actions.definitions;

import com.common.utils.core.authentication.SessionManager;
import io.cucumber.java.en.Given;

public class AuthenticationSteps {

    @Given("I authenticate as user {string} on product {string}")
    public void authenticateAsUser(String username, String product) {
        SessionManager.set(product, username);
    }
}
