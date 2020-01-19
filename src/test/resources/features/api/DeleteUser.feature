@DeleteUserFeature @Users @API @Regression
Feature: Delete User

  @Positive
  Scenario: Delete user success
    Given [api] set id to '1'
    When  [api] send delete user request
    Then  [api] delete user status code must be '204'