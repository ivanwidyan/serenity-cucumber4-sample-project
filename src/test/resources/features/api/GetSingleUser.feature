@GetSingleUserFeature @Users @API @Regression
Feature: Get Single User

  @Positive
  Scenario: Get single user success
    Given [api] set id to '1'
    When  [api] send get single user request
    Then  [api] get single user status code must be '200'
    And   [api] get single user response equals with request