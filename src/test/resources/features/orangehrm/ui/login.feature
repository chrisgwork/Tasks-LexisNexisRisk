@ui @login
Feature: Login functionality

  Scenario Outline: Login - User can login successfully - User <username>
    Given I navigate to the base path on product saucedemo
    When I fill input by name "user-name" with text "<username>"
    And I fill input by name "password" for user <username>
    And I click input by name "login-button"
    Then the button with class "shopping_cart_link" should be visible

    Examples:
      | username                |
      | standard_user           |
      | locked_out_user         |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |