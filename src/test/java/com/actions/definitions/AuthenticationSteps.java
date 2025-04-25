package com.actions.definitions;

import com.core.authentication.SessionManager;
import com.core.enums.Product;
import io.cucumber.java.en.Given;

public class AuthenticationSteps {

    @Given("I authenticate as user {username} on product {product}")
    public void authenticateAsUser(String username, Product.name product) {
        SessionManager.set(product, username);
    }
}
