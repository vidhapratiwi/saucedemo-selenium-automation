Feature: cancel button on overview page
  @CancelOverview
  Scenario: user verify cancel button on overview page
    Given user on overview page
    When user clicks on cancel button
    Then user is directed to your info page