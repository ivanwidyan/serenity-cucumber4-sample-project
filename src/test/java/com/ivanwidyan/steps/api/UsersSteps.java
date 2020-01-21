package com.ivanwidyan.steps.api;

import com.ivanwidyan.module.api.UsersController;
import com.ivanwidyan.module.api.data.UsersData;
import com.ivanwidyan.module.api.response.createuser.CreateUserResponse;
import com.ivanwidyan.module.api.response.getuser.GetSingleUserResponse;
import com.ivanwidyan.module.api.response.updateuser.UpdateUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UsersSteps extends ScenarioSteps {

    //---------------------------- Set Parameters
    @Given("^\\[api] set id to '(.*)'$")
    public void api_set_id_to (Integer value) {
        UsersData.setId(value);
    }

    @Given("^\\[api] set name to '(.*)'$")
    public void set_name_to (String value) {
        UsersData.setName(value);
    }

    @Given("^\\[api] set job to '(.*)'$")
    public void set_job_to (String value) {
        UsersData.setJob(value);
    }

    //---------------------------- Send Request
    @When("^\\[api] send get single user request$")
    public void send_get_single_user_request () {
        UsersData.setGetSingleUserResponse(UsersController.getUser());
    }

    @When("^\\[api] send create user request$")
    public void send_create_user_request () {
        UsersData.setCreateUserResponse(UsersController.createUser());
    }

    @When("^\\[api] send update user request$")
    public void send_update_user_request () {
        UsersData.setUpdateUserResponse(UsersController.updateUser());
    }

    @When("^\\[api] send delete user request$")
    public void send_delete_user_request () {
        UsersData.setDeleteUserResponse(UsersController.deleteUser());
    }

    //---------------------------- Check Status Code
    @Then("^\\[api] get single user status code must be '(\\d+)'$")
    public void api_get_single_user_status_code_must_be (int code) {
        // Assert the status code from the Response to be equal to input code
        assertThat(UsersData.getGetSingleUserResponse().statusCode(), equalTo(code));

        // Assert statusCode directly from the Response method
        UsersData.getGetSingleUserResponse().
                then().
                    statusCode(code);
    }

    @Then("^\\[api] create user status code must be '(\\d+)'$")
    public void api_create_user_status_code_must_be (int code) {
        assert_with_hamcrest_that_create_user_status_code_must_be(code);

        assert_with_rest_assured_that_create_user_status_code_must_be(code);
    }

    @Then("^\\[api] assert with hamcrest that create user status code must be '(\\d+)'$")
    public void assert_with_hamcrest_that_create_user_status_code_must_be (int code) {
        assertThat(UsersData.getCreateUserResponse().statusCode(), equalTo(code));
    }

    @Then("^\\[api] assert with rest assured that create user status code must be '(\\d+)'$")
    public void assert_with_rest_assured_that_create_user_status_code_must_be (int code) {
        UsersData.getCreateUserResponse().
                then().
                statusCode(code);
    }

    @Then("^\\[api] update user status code must be '(\\d+)'$")
    public void api_update_user_status_code_must_be (int code) {
        assertThat(UsersData.getUpdateUserResponse().statusCode(), equalTo(code));

        UsersData.getUpdateUserResponse().
                then().
                    statusCode(code);
    }

    @Then("^\\[api] delete user status code must be '(\\d+)'$")
    public void api_delete_user_status_code_must_be (int code) {
        assertThat(UsersData.getDeleteUserResponse().statusCode(), equalTo(code));

        UsersData.getDeleteUserResponse().
                then().
                    statusCode(code);
    }

    //---------------------------- Assert Response
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

    @Then("^\\[api] create user response equals with request$")
    public void api_create_user_api_response_equals_with_name_request () {
        CreateUserResponse response = UsersData.getCreateUserResponse()
                .getBody().as(CreateUserResponse.class);
        assertThat(response.getName(), equalTo(UsersData.getName()));
        assertThat(response.getJob(), equalTo(UsersData.getJob()));

        UsersData.getCreateUserResponse().
                then().
                    body("name", equalTo(UsersData.getName())).
                    body("job", equalTo(UsersData.getJob()));
    }

    @Then("^\\[api] update user response equals with request$")
    public void api_update_user_api_response_equals_with_name_request () {
        UpdateUserResponse response = UsersData.getUpdateUserResponse()
                .getBody().as(UpdateUserResponse.class);
        assertThat(response.getName(), equalTo(UsersData.getName()));
        assertThat(response.getJob(), equalTo(UsersData.getJob()));

        UsersData.getUpdateUserResponse().
                then().
                    body("name", equalTo(UsersData.getName())).
                    body("job", equalTo(UsersData.getJob()));
    }
}