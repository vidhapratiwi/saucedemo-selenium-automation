Feature: cancel button on your info page
  @CancelYourInfo
  Scenario: user verify cancel button on your info page
    Given user is at your info page
    When user click cancel button
    Then user directed to cart page