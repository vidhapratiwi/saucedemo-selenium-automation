Feature: saucedemo logout
  @Logout
  Scenario:
    Given user on homepage
    When user click sidebar
    And user click logout
    Then user successfully logout