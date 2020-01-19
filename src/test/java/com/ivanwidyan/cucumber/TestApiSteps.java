package com.ivanwidyan.cucumber;

import com.ivanwidyan.module.api.SampleAPI;
import com.ivanwidyan.module.api.response.getuser.GetSingleUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestApiSteps extends ScenarioSteps {

    String id = "";
    GetSingleUserResponse response;

    @Given("test api set id to '(.*)'")
    public void test_api_set_id_to (String value) {
        id = value;
    }

    @When("send get user api")
    public void send_get_user_api () {
        response = SampleAPI.getUser(Integer.valueOf(id));
        System.out.println(response.toString());
    }

    @When("send delete user api")
    public void send_delete_user_api () {
        response = SampleAPI.deleteUser(Integer.valueOf(id));
        System.out.println(response.toString());
    }

    @Then("get user api response equals with request")
    public void get_user_api_response_equals_with_request () {
        assertThat(response.getData().getId(), equalTo(Integer.valueOf(id)));
    }
}