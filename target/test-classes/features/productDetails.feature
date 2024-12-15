Feature: product
  @Product
  Scenario: user see product details
    Given user is on dashboard page
    When user click product name
    Then user see product details