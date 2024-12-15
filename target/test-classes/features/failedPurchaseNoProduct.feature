Feature: failed purchase without product
  @FailedNoProduct
  Scenario: user make a failed purchase without product
    Given user is on cart page
    When user click the checkout button
    Then error message shown and tell user to add product