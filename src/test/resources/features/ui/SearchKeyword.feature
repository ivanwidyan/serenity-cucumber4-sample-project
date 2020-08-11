@SearchKeywordFeature @GooglePage @UI @Regression
Feature: Search Keyword

  # This is a sample scenario for testing search in Google

  @Positive
  Scenario: Search keyword success
    Given [ui] google page is opened
    And   [ui] set keyword to 'Test'
    When  [ui] search using keyword
    Then  [ui] search results should be containing keyword

  @Positive
  Scenario Outline: Search keyword for '<keyword>' success
    Given [ui] google page is opened
    And   [ui] set keyword to '<keyword>'
    When  [ui] search using keyword
    Then  [ui] search results should be containing keyword

    Examples:
      | keyword |
      | apple   |
      | banana  |
      | melon   |