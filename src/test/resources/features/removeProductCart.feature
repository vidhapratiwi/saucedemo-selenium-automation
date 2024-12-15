Feature: Remove product from cart
  @RemoveProductCart
  Scenario: user remove product from cart page
    Given user added product and is on cart page
    When user click the remove button
    Then product is removed from cart