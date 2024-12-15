Feature: Remove product from home
  @RemoveProductHome
  Scenario: user remove product frome home page
    Given user added product and is on home page
    When user click remove button
    Then product removed from cart
    And add to cart button is enabled