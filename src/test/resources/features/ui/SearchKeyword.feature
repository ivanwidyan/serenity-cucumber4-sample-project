@SearchKeywordFeature @GooglePage @UI @Regression
Feature: Search Keyword

  @Positive
  Scenario: Search keyword success
    Given [ui] google page is opened
    And   [ui] set keyword to 'Test'
    When  [ui] search using keyword
    Then  [ui] search results should be containing keyword