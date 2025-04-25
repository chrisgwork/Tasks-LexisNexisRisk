@ui @login
Feature: Login functionality

  Scenario: Login - User can login successfully - User tomsmith
    Given I navigate to "/login" on product herokuapp
    When I fill input by name "username" with text "tomsmith"
    And I fill input by name "password" for user tomsmith
    And I click button by text "Login"
    Then the class "example" should equal text "Secure Area"