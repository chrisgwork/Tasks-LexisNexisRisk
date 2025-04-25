@ui @authentication @session_manager
Feature: Filling and submitting a claim

  Scenario Outline: Session Manager demo
    Given I wait for <delay> seconds
    When I authenticate as user standard_user on product saucedemo
    And I navigate to "/inventory.html" on product saucedemo
    Then the button with class "shopping_cart_link" should be visible

    Examples:
      | delay |
      | 0     |
      | 5     |