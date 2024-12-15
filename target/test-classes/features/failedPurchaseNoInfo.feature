Feature: failed purchase without info form
  @FailedNoInfo
  Scenario: user make a failed purchase without fill info form
    Given user added product and on info page
    When user click on continue button
    Then error message shown and tell user to fill form