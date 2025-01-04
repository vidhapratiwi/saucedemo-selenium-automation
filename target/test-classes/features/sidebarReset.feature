Feature: sidebar menu - reset app state
  @Sidebar @ResetAppState
    Scenario:
    Given user added item to cart and is on sidebar menu
    When user click reset app state
    Then all item on cart is removed
    And remove button changed to add to cart button