@Api @User @Regression
Feature: Test API

  @GetSingleUser
  Scenario: Get single user success
    Given test api set id to '1'
    When  send get user api
    Then  get user api response equals with request

  @GetSingleUser
  Scenario Outline: Get failed because '<reason>'
    Given test api set id to '<id>'
    When  send get user api

    Examples:
    | id          | reason                |
    |             | id is blank           |
    | null        | id is null            |
    | text        | id is a text          |
    | 99999999999 | id is more than limit |

  @DeleteSingleUser
  Scenario: Delete user success
    Given test api set id to '1'
    When  send delete user api