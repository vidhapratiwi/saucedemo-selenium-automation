Feature: sidebar menu - about
  @Sidebar @About
  Scenario:
    Given user is on sidebar menu
    When user click logout menu
    Then user success logout