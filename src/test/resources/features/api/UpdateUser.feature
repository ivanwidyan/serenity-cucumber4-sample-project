@UpdateUserFeature @Users @API @Regression
Feature: Update User

  @Positive
  Scenario: Update user success
    Given [api] set id to '1'
    And   [api] set name to 'Widyan'
    And   [api] set job to 'SDET'
    When  [api] send update user request
    Then  [api] update user status code must be '200'
    And   [api] update user response equals with request