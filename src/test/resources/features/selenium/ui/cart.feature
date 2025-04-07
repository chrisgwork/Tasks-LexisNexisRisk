@UI
Feature: Cart functionality

  @cart
  Scenario Outline: <JIRA_ID> - Cart - Viewing single item in cart - User <USERNAME>
    Given I authenticate as user <USERNAME> on product "SELENIUM"
    And I navigate to "/inventory.html" on product "SELENIUM"
    And I click button by data test id <ADD_TO_CART>
    And I click button by data test id "shopping-cart-link"
    Then The button with data test id "checkout" is visible

    Examples:
      | JIRA_ID   | USERNAME                  | ADD_TO_CART                                     |
      | JIRA-1012 | "performance_glitch_user" | "add-to-cart-sauce-labs-backpack"               |
      | JIRA-1013 | "performance_glitch_user" | "add-to-cart-sauce-labs-bike-light"             |
      | JIRA-1014 | "performance_glitch_user" | "add-to-cart-sauce-labs-bolt-t-shirt"           |
      | JIRA-1015 | "standard_user"           | "add-to-cart-sauce-labs-fleece-jacket"          |
      | JIRA-1016 | "standard_user"           | "add-to-cart-sauce-labs-onesie"                 |
      | JIRA-1017 | "standard_user"           | "add-to-cart-test.allthethings()-t-shirt-(red)" |

  @cart
  Scenario Outline: <JIRA_ID> - Cart - Checkout button routes user correctly - User <USERNAME>
    Given I authenticate as user <USERNAME> on product "SELENIUM"
    And I navigate to "/inventory.html" on product "SELENIUM"
    And I click button by data test id <ADD_TO_CART>
    And I click button by data test id "shopping-cart-link"
    And I click button by data test id "checkout"
    Then The URL will contain "checkout-step-one.html"

    Examples:
      | JIRA_ID   | USERNAME        | ADD_TO_CART                                     |
      | JIRA-1018 | "standard_user" | "add-to-cart-sauce-labs-onesie"                 |
      | JIRA-1019 | "standard_user" | "add-to-cart-test.allthethings()-t-shirt-(red)" |

  @cart
  Scenario Outline: <JIRA_ID> - Cart - Checkout button routes user correctly - User <USERNAME>
    Given I authenticate as user <USERNAME> on product "SELENIUM"
    And I navigate to "/inventory.html" on product "SELENIUM"
    And I click button by data test id <ADD_TO_CART>
    And I click button by data test id "shopping-cart-link"
    And I click button by data test id "checkout"
    And I fill input by data test id "firstName" with a random word
    And I fill input by data test id "lastName" with a random word
    And I fill input by data test id "postalCode" with a random post code
    And I click button by data test id "continue"
    Then The URL will contain "checkout-step-two.html"

    Examples:
      | JIRA_ID   | USERNAME        | ADD_TO_CART                                     |
      | JIRA-1020 | "standard_user" | "add-to-cart-test.allthethings()-t-shirt-(red)" |

  @cart
  Scenario Outline: <JIRA_ID> - Cart - User can check out 3 items - User <USERNAME>
    Given I authenticate as user <USERNAME> on product "SELENIUM"
    And I navigate to "/inventory.html" on product "SELENIUM"
    And I click button by data test id "add-to-cart-test.allthethings()-t-shirt-(red)"
    And I click button by data test id "add-to-cart-sauce-labs-backpack"
    And I click button by data test id "add-to-cart-sauce-labs-bike-light"
    And I click button by data test id "shopping-cart-link"
    And I click button by data test id "checkout"
    And I fill input by data test id "firstName" with a random word
    And I fill input by data test id "lastName" with a random word
    And I fill input by data test id "postalCode" with a random post code
    And I click button by data test id "continue"
    And I click button by data test id "finish"
    Then The URL will contain "checkout-complete.html"

    Examples:
      | JIRA_ID   | USERNAME                  |
      | JIRA-1021 | "standard_user"           |
      | JIRA-1022 | "problem_user"            |
      | JIRA-1023 | "performance_glitch_user" |
      | JIRA-1024 | "error_user"              |
      | JIRA-1025 | "visual_user"             |