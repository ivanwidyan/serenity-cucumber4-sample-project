package com.ivanwidyan.runner;

import com.ivanwidyan.module.api.SampleAPI;
import com.ivanwidyan.module.api.response.getuser.GetSingleUserResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class ApiRunner {

    @Test
    public void getUser() {
        int id = 1;
        GetSingleUserResponse response = SampleAPI.getUser(id);
        assertThat(response.getData().getId(), equalTo(id));
        System.out.println(response.toString());
        System.out.println(response.getData().getAvatar());
    }

    @Test
    public void addUser() {
        SampleAPI.addUser("ivan", "QA");
    }
}
