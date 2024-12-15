Feature: sorting products
  @Sorting
  Scenario Outline: user sorting products
    Given user is on the dashboard page
    When user click "<sortingOption>" sorting option
    Then items should be sorted correctly

    Examples:
      | sortingOption |
      | az            |
      | za            |
      | hilo          |
      | lohi          |