@UI @webform
Feature: Webform functionality

  @input
  Scenario Outline: Webform - User can fill their username - User <username>
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    When I fill input by id "my-text-id" with text "<username>"
    Then I take a screenshot

    Examples:
      | username     |
      | exampleuser1 |
      | exampleuser2 |

  @authentication
  Scenario Outline: Webform - User can fill their password - User <username>
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-password" for user <username>
    Then I take a screenshot

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
    Then I take a screenshot

  @dropDown @datalist
  Scenario Outline: Webform - User can select <option> from dropdown datalist - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by text "Dropdown (datalist)" with text "<option>"
    Then I take a screenshot

    Examples:
      | option        |
      | San Francisco |
      | New York      |
      | Los Angeles   |
      | Chicago       |

  @dropdown @select
  Scenario Outline: Webform - User can select <option> from dropdown select - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill dropdown box by text "Dropdown (select)" with option "<option>"
    Then I take a screenshot

    Examples:
      | option |
      | One    |
      | Two    |
      | Three  |

  @file
  Scenario Outline: Webform - User can upload file <file_type> - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill file upload by name "my-file" with file <file_type>
    Then I take a screenshot

    Examples:
      | file_type |
      | PNG.png   |
      | JPG.jpg   |

  @checkbox
  Scenario Outline: Webform - User can <action> a checkbox - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I <action> the checkbox by id "<id>"
    Then I take a screenshot

    Examples:
      | action  | id         |
      | check   | my-check-2 |
      | uncheck | my-check-1 |

  @radioButton
  Scenario: Webform - User can check a radio button - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I check the radio button by id "my-radio-2"
    Then I take a screenshot

  @pickDate
  Scenario: Webform - User can pick a date from a calendar - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-date" with text "04/02/2025"
    Then I take a screenshot

  @pickColour
  Scenario: Webform - User can pick a colour from a colour picker - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I fill input by name "my-colors" with text "#dbff33"
    Then I take a screenshot

  @range
  Scenario Outline: Webform - User can slide range to value <value> - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I set range input by name "my-range" to value "<value>"
    Then I take a screenshot

    Examples:
      | value |
      | 0     |
      | 10    |

  @submit
  Scenario: Webform - User can submit form - No User
    Given I navigate to "/selenium/web/web-form.html" on product "SELENIUM"
    And I click button by text "Submit"
    Then the class "lead" should equal text "Received!"
    Then I take a screenshot