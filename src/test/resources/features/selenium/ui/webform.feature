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

  @input
  Scenario Outline: Webform - User can verify a <status> input - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    Then the input with name "<name>" should be <status>

    Examples:
      | name        | status   |
      | my-disabled | disabled |
      | my-readonly | readonly |

  @textarea
  Scenario: Webform - User can fill a text area - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-textarea" with random word
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

  @dropDown @datalist
  Scenario Outline: Webform - User can select <option> from dropdown datalist - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by text "Dropdown (datalist)" with text "<option>"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | option        |
      | San Francisco |
      | New York      |
      | Los Angeles   |
      | Chicago       |

  @dropdown @select
  Scenario Outline: Webform - User can select <option> from dropdown select - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I select dropdown box by text "Dropdown (select)" and select option "<option>"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | option |
      | One    |
      | Two    |
      | Three  |

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

  @pickDate
  Scenario: Webform - User can pick a date from a calendar - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-date" with text "04/02/2025"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

  @pickColour
  Scenario: Webform - User can pick a colour from a colour picker - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-colors" with text "#dbff33"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

  @range
  Scenario Outline: Webform - User can slide range to value <value> - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I set range input by name "my-range" to value "<value>"
    And I click button by text "Submit"
    Then the class "lead" should contain text "Received!"

    Examples:
      | value |
      | 0     |
      | 10    |