@UI
Feature: Webform functionality

  @webform
  Scenario Outline: Login - User can fill their username - User <username>
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    When I fill input by id "my-text-id" with text <username>
    And I click button by text "Submit"
    Then The class "lead" should contain text "Received!"

    Examples:
      | username       |
      | "exampleuser1" |
      | "exampleuser2" |

  @webform
  Scenario Outline: Login - User can fill their password - User <username>
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-password" for user <username>
    And I click button by text "Submit"
    Then The class "lead" should contain text "Received!"

    Examples:
      | username       |
      | "exampleuser1" |
      | "exampleuser2" |

  @webform
  Scenario Outline: Login - User can select country from drop down - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I select <option> from the dropdown titled "Dropdown (datalist)"
    And I click button by text "Submit"
    Then The class "lead" should contain text "Received!"

    Examples:
      | option          |
      | "San Francisco" |
      | "New York"      |
      | "Seattle"       |
      | "Los Angeles"   |
      | "Chicago"       |