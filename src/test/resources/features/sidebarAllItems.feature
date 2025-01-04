Feature: sidebar menu - all items
  @Sidebar @Allitem
    Scenario:
    Given user already opened sidebar menu
    When user click all item
    Then the product item is displayed