# Serenity Cucumber 4 Sample Project

[![CircleCI](https://circleci.com/gh/ivanwidyan/serenity-cucumber4-sample-project.svg?style=svg)](https://circleci.com/gh/ivanwidyan/serenity-cucumber4-sample-project)

This is a Serenity BDD sample project which gives examples on how to run
API automation test using RestAssured and for web automation it uses Selenium for it's core.
The automation test is run on Cucumber 4.

The project will show some examples of creating features which glued with steps, 
positive and negative scenarios, and also running same test case with different parameters
using Scenario Outline.

For the API, you will see GET, POST, PUT, and DELETE API automation test 
using [Reqres](https://reqres.in/) as the endpoint. It will show you how to set
headers, request body, and hitting the API. The response then will be used for assertion
which can be done in the RestAssured or casted for to Java object.

In the UI you will find opening the URL you want and find element or elements using XPath and use it for your action and assertion.

Below are the examples  of Cucumber scenarios for API and UI that written in Gherkin language.

## Sample API Scenario
This is an example of scenario for a Get Single User API:

```Gherkin
@GetSingleUserFeature @Users @Api @Regression
Feature: Get Single User

  @Positive
  Scenario: Get single user success
    Given [api] set id to '1'
    When  [api] send get single user request
    Then  [api] get single user status code must be '200'
    And   [api] get single user response equals with request
```

The glue codes for the scenario are these:

```java
    @Given("^\\[api] set id to '(.*)'$")
    public void api_set_id_to (Integer value) {
        UsersData.setId(value);
    }

    @When("^\\[api] send get single user request$")
    public void send_get_single_user_request () {
        UsersData.setGetSingleUserResponse(UsersController.getUser());
    }

    @Then("^\\[api] get single user status code must be '(\\d+)'$")
    public void api_get_single_user_status_code_must_be (int code) {
        // Assert the status code from the Response to be equal to input code
        assertThat(UsersData.getGetSingleUserResponse().statusCode(), equalTo(code));

        // Assert statusCode directly from the Response method
        UsersData.getGetSingleUserResponse().
                then().
                    statusCode(code);
    }

    @Then("^\\[api] get single user response equals with request$")
    public void api_get_single_user_response_equals_with_request () {
        // Assert by casting the Response to Java Object
        GetSingleUserResponse response = UsersData.getGetSingleUserResponse()
                .getBody().as(GetSingleUserResponse.class);
        assertThat(response.getData().getId(), equalTo(UsersData.getId()));

        // Assert directly using Rest Assured then commands
        UsersData.getGetSingleUserResponse().
                then().
                    body("data.id", equalTo(UsersData.getId()));
    }
```

This is the API controller which is called from the steps:
```java
public static Response getUser () {
    return  given().
                header("Accept", "application/json").
            when().
                get("https://reqres.in/api/users/" + UsersData.getId());
}
```

## Sample UI Scenario
This is an example of search keyword scenario in Google web application:

```Gherkin
@SearchKeywordFeature @GooglePage @UI @Regression
Feature: Search Keyword

  @Positive
  Scenario: Search keyword success
    Given [ui] google page is opened
    And   [ui] set keyword to 'Quality Assurance'
    When  [ui] search using keyword
    Then  [ui] search results should be containing keyword
```

The glue codes for the scenario are these:

```java
    @Given("^\\[ui] google page is opened$")
    public void ui_google_page_is_opened() {
        googlePage.openHomePage();
    }

    @Given("^\\[ui] set keyword to '(.*)'$")
    public void ui_set_keyword_to (String value) {
        GooglePageData.setKeyword(value);
    }

    @When("^\\[ui] search using keyword$")
    public void api_set_id_to () {
        googlePage.doSearch();
    }

    @Then("^\\[ui] search results should be containing keyword$")
    public void send_get_single_user_request () {
        List<String> list = googlePage.getSearchData();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toLowerCase());
            assertThat(list.get(i).toLowerCase(), Matchers.containsString(GooglePageData.getKeyword().toLowerCase()));
        }
    }
```

## Running
To run the project you can either run it directly from the `CucumberRunner` test runner class 
or using maven command `mvn verify`.

By default the web automation will run on Chrome so you need to override the `driver` if you want to use other browser.
```json
$ mvn clean verify -Dwebdriver.driver=firefox
```