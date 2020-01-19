@CreateUserFeature @Users @Api @Regression
Feature: Create User

  @Positive
  Scenario: Create user success
    Given [api] set name to 'Ivan'
    And   [api] set job to 'Quality Engineer'
    When  [api] send create user request
    Then  [api] create user status code must be '201'
    And   [api] create user response equals with request