Feature: add product to cart
  @AddToCart
  Scenario: user add product to cart
    Given user on dashboard page
    When user click on add to cart button
    Then remove button is enable