Feature: add product to cart from product details
  @AddToCart @ProductDetails
  Scenario: user adding a product to cart from product details
    Given user is on product details page
    When user click add to cart
    Then remove button is displayed
    And cart badge is displayed
