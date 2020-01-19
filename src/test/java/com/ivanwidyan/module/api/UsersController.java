package com.ivanwidyan.module.api;

import com.ivanwidyan.module.api.request.createuser.CreateUserRequest;
import com.ivanwidyan.module.api.request.updateuser.UpdateUserRequest;
import com.ivanwidyan.module.api.data.UsersData;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class UsersController {
    public static Response getUser () {
        return  given().
                    header("Accept", "application/json").
                when().
                    get("https://reqres.in/api/users/" + UsersData.getId());
    }

    public static Response createUser() {
        CreateUserRequest request = new CreateUserRequest();
        request.setName(UsersData.getName());
        request.setJob(UsersData.getJob());
        return  given().
                    header("Content-Type", "application/json").
                    header("Accept", "application/json").
                    body(request).
                when().
                    post("https://reqres.in/api/users");
    }

    public static Response updateUser () {
        UpdateUserRequest request = new UpdateUserRequest();
        request.setName(UsersData.getName());
        request.setJob(UsersData.getJob());

        return  given().
                    header("Content-Type", "application/json").
                    header("Accept", "application/json").
                    body(request).
                when().
                    put("https://reqres.in/api/users/" + UsersData.getId());
    }

    public static Response deleteUser () {
        return  given().
                    header("Accept", "application/json").
                when().
                    delete("https://reqres.in/api/users/" + UsersData.getId());
    }
}