Feature: failed purchase
  @FailedInvalidFirstName
  Scenario Outline: user make a failed purchase with invalid first name format
    Given  user is on your info page
    When user enter <firstName> as first name
    Then user enter <lastName> as last name
    And user enter <zipCode> as zip or postal code
    And user clicks continue button
    Then an error message <expectedErrorMessage> should be displayed

    Examples:
    | firstName | lastName | zipCode | expectedErrorMessage                    |
    | !@#$%^    | ina      | 43299   | "Error: First name must be valid"       |
    | moa       | !@#$%    | 43299   | "Error: Last name must be valid"        |
    | moa       | ina      | !@#$%^  | "Error: Zip/postal code must be valid"  |
    |           |          |         | "Error: All fields are required"        |