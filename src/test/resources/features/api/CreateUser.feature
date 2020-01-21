@CreateUserFeature @Users @API @Regression
Feature: Create User

  @Positive
  Scenario: Create user success
    Given [api] set name to 'Ivan'
    And   [api] set job to 'Quality Engineer'
    When  [api] send create user request
    Then  [api] create user status code must be '201'
    And   [api] create user response equals with request

   @Negative @CreateUserAssertWithHamcrest
   Scenario: Create user success and check with hamcrest only
     Given [api] set name to 'Dennis'
     And   [api] set job to 'SDET'
     When  [api] send create user request
     Then  [api] assert with hamcrest that create user status code must be '301'
     And   [api] create user response equals with request

  @Negative @CreateUserAssertWithRestAssured
  Scenario: Create user success and check with rest assured only
    Given [api] set name to 'Steve'
    And   [api] set job to 'Software Engineer'
    When  [api] send create user request
    Then  [api] assert with rest assured that create user status code must be '500'
    And   [api] create user response equals with request