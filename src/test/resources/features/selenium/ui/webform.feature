@UI @webform
Feature: Webform functionality

  @input
  Scenario Outline: Webform - User can fill their username - User <username>
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    When I fill input by id "my-text-id" with text "<username>"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | username     |
      | exampleuser1 |
      | exampleuser2 |

  @authentication
  Scenario Outline: Webform - User can fill their password - User <username>
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-password" for user <username>
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | username     |
      | exampleuser1 |
      | exampleuser2 |

  @dropdown
  Scenario Outline: Webform - User can select <option> from drop down - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I select "<option>" from the dropdown titled "Dropdown (datalist)"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | option        |
      | San Francisco |
      | New York      |
      | Los Angeles   |
      | Chicago       |

  @file
  Scenario Outline: Webform - User can upload file <file_type> - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I upload file into input by name "my-file" with file <file_type>
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | file_type |
      | PNG.png   |
      | JPG.jpg   |

  @checkbox
  Scenario Outline: Webform - User can <action> a checkbox - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I <action> the checkbox by id "<id>"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | action  | id         |
      | check   | my-check-2 |
      | uncheck | my-check-1 |

  @radioButton
  Scenario: Webform - User can check a radio button - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I check the radio button by id "my-radio-2"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"