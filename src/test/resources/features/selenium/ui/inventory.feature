@UI
Feature: Inventory functionality

  @inventory
  Scenario Outline: <JIRA_ID> - Inventory - Adding single item to cart - User <USERNAME>
    Given I authenticate as user <USERNAME> on product "SELENIUM"
    And I navigate to "/inventory.html" on product "SELENIUM"
    And I click button by data test id <ADD_TO_CART>
    Then The button with data test id <REMOVE_FROM_CART> is visible

    Examples:
      | JIRA_ID   | USERNAME                  | ADD_TO_CART                                     | REMOVE_FROM_CART                           |
      | JIRA-1006 | "performance_glitch_user" | "add-to-cart-sauce-labs-backpack"               | "remove-sauce-labs-backpack"               |
      | JIRA-1007 | "performance_glitch_user" | "add-to-cart-sauce-labs-bike-light"             | "remove-sauce-labs-bike-light"             |
      | JIRA-1008 | "performance_glitch_user" | "add-to-cart-sauce-labs-bolt-t-shirt"           | "remove-sauce-labs-bolt-t-shirt"           |
      | JIRA-1009 | "standard_user"           | "add-to-cart-sauce-labs-fleece-jacket"          | "remove-sauce-labs-fleece-jacket"          |
      | JIRA-1010 | "standard_user"           | "add-to-cart-sauce-labs-onesie"                 | "remove-sauce-labs-onesie"                 |
      | JIRA-1011 | "standard_user"           | "add-to-cart-test.allthethings()-t-shirt-(red)" | "remove-test.allthethings()-t-shirt-(red)" |

  @inventory
  Scenario Outline: <JIRA_ID> - Inventory - Adding multiple items to cart - User <USERNAME>
    Given I authenticate as user <USERNAME> on product "SELENIUM"
    And I navigate to "/inventory.html" on product "SELENIUM"
    And I click button by data test id "add-to-cart-sauce-labs-backpack"
    And I click button by data test id "add-to-cart-sauce-labs-bike-light"
    Then The button with data test id "remove-sauce-labs-backpack" is visible
    Then The button with data test id "remove-sauce-labs-bike-light" is visible

    Examples:
      | JIRA_ID   | USERNAME                  |
      | JIRA-1026 | "standard_user"           |
      | JIRA-1027 | "problem_user"            |
      | JIRA-1028 | "performance_glitch_user" |
      | JIRA-1029 | "error_user"              |
      | JIRA-1030 | "visual_user"             |

  @inventory
  Scenario Outline: <JIRA_ID> - Inventory - Removing an item from the cart - User <USERNAME>
    Given I authenticate as user <USERNAME> on product "SELENIUM"
    And I navigate to "/inventory.html" on product "SELENIUM"
    And I click button by data test id "add-to-cart-sauce-labs-backpack"
    And I click button by data test id "remove-sauce-labs-backpack"
    Then The button with data test id "remove-sauce-labs-bike-light" is not visible

    Examples:
      | JIRA_ID   | USERNAME                  |
      | JIRA-1031 | "standard_user"           |
      | JIRA-1032 | "problem_user"            |
      | JIRA-1033 | "performance_glitch_user" |
      | JIRA-1034 | "error_user"              |
      | JIRA-1035 | "visual_user"             |