Feature: successful purchase
  @SP
  Scenario: user make a successful purchase
    Given user added product and on cart page
    When user click checkout button
    Then user on your info page
    And user input firstname
    And user input lastname
    And user input postalcode
    And user click continue button
    Then user is on overview page
    And user click finish button
    Then purchase successfully made
    And success message appear

#    Examples:
#      | firstname | lastname | postalcode
#      | moa       | ina      | 43299