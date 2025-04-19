@UI @login
Feature: Login functionality

  Scenario: Login - User can login successfully - User Admin
    Given I navigate to "/web/index.php/auth/login" on product orangehrm
    When I fill input by name "username" with text "Admin"
    And I fill input by name "password" for user Admin
    And I click button by text "Login"
    Then the URL will contain "/web/index.php/dashboard/index"