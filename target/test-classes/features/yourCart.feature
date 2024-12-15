Feature: your cart page
  @YourCart
  Scenario: user can see product on your cart page
    Given user already added product to cart
    When user click on shopping cart
    Then user see product on your cart page
