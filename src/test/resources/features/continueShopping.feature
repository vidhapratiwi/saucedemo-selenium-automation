Feature: continue shopping button
  @ContinueShoppingButton
  Scenario: validate continue shopping button
    Given user added product to cart
    When user click continue shopping
    Then user directed to home page