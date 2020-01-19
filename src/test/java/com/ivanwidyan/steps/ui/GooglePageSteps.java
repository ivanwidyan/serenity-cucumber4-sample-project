package com.ivanwidyan.steps.ui;

import com.ivanwidyan.module.ui.GooglePage;
import com.ivanwidyan.module.ui.data.GooglePageData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class GooglePageSteps extends ScenarioSteps {

    private GooglePage googlePage;

    //---------------------------- Preparations
    @Given("^\\[ui] google page is opened$")
    public void ui_google_page_is_opened() {
        googlePage.openHomePage();
    }

    @Given("^\\[ui] set keyword to '(.*)'$")
    public void ui_set_keyword_to (String value) {
        GooglePageData.setKeyword(value);
    }

    //---------------------------- Actions
    @When("^\\[ui] search using keyword$")
    public void api_set_id_to () {
        googlePage.doSearch();
    }

    //---------------------------- Assertion
    @Then("^\\[ui] search results should be containing keyword$")
    public void send_get_single_user_request () {
        List<String> list = googlePage.getSearchData();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toLowerCase());
            assertThat(list.get(i).toLowerCase(), Matchers.containsString(GooglePageData.getKeyword().toLowerCase()));
        }
    }
}