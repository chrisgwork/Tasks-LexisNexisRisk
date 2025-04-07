@UI @solo
Feature: Login functionality

  @login
  Scenario Outline: <JIRA_ID> - Login - User can login successfully - User <username>
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    When I fill input by id "my-text-id" with text <username>
    And I fill input by name "my-password" for user <username>
    And I select "San Francisco" from the dropdown titled "Dropdown (datalist)"
    And I click button by text "Submit"
    Then The class "lead" should contain text "Received!"

    Examples:
      | JIRA_ID   | username       |
      | JIRA-1000 | "exampleuser1" |
#      | JIRA-1001 | "exampleuser2" |