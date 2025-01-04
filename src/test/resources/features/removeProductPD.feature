Feature: Remove product from product details
  @RemoveProductPD
  Scenario: user remove product from product details
    Given user has already added product to cart
    When user clicks remove button
    Then product removed from the cart
    And add to cart button is displayed