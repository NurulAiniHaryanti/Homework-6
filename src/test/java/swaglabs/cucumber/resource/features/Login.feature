Feature: login functionality

Scenario Outline: Ensure login functionality
    Given user is on SwagLabs login page
    When user input <username> as username
    And user input <password> as password 
    And user click login button
    Then user verify <status> login result

Examples:
    | username     | password    | status  |
    |standard_user |secret_sauce | success |
    |standar_name  |secret_name  | failed  |

Scenario Outline: Ensure add cart functionality
    Given user is on SwagLabs login page
    When user input <username> as username
    And user input <password> as password 
    And user click login button
    And user add cart sauce labs bike light
    Then cart is added

Examples:
    | username     | password    | status  |
    |standard_user |secret_sauce | success |

Scenario Outline: Ensure remove cart functionality
    Given user is on SwagLabs login page
    When user input <username> as username
    And user input <password> as password 
    And user click login button
    And user add cart sauce labs bike light
    Then cart is added
    And user remove cart sauce labs bike light
    Then cart is blank

Examples:
    | username     | password    | status  |
    |standard_user |secret_sauce | success |