package com.ivanwidyan.module.api.data;

import io.restassured.response.Response;

public class UsersData {
    private static Integer id;
    private static String name;
    private static String job;

    private static Response getSingleUserResponse;
    private static Response createUserResponse;
    private static Response updateUserResponse;
    private static Response deleteUserResponse;

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        UsersData.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UsersData.name = name;
    }

    public static String getJob() {
        return job;
    }

    public static void setJob(String job) {
        UsersData.job = job;
    }

    public static Response getGetSingleUserResponse() {
        return getSingleUserResponse;
    }

    public static void setGetSingleUserResponse(Response getSingleUserResponse) {
        UsersData.getSingleUserResponse = getSingleUserResponse;
    }

    public static Response getCreateUserResponse() {
        return createUserResponse;
    }

    public static void setCreateUserResponse(Response createUserResponse) {
        UsersData.createUserResponse = createUserResponse;
    }

    public static Response getUpdateUserResponse() {
        return updateUserResponse;
    }

    public static void setUpdateUserResponse(Response updateUserResponse) {
        UsersData.updateUserResponse = updateUserResponse;
    }

    public static Response getDeleteUserResponse() {
        return deleteUserResponse;
    }

    public static void setDeleteUserResponse(Response deleteUserResponse) {
        UsersData.deleteUserResponse = deleteUserResponse;
    }
}
