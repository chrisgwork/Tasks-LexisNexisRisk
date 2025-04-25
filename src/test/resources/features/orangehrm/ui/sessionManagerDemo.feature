@ui @authentication @session_manager
Feature: Filling and submitting a claim

  Scenario Outline: Session Manager demo
    Given I wait for <delay> seconds
    * I wait for 2 seconds
    When I authenticate as user tomsmith on product herokuapp
    * I wait for 2 seconds
    And I navigate to "/secure" on product herokuapp
    * I wait for 2 seconds
    * I take a screenshot
#    Then the URL will contain

    Examples:
      | delay |
      | 0     |
      | 5     |