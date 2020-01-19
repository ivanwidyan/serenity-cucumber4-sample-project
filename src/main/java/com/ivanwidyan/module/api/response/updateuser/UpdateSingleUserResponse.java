package com.ivanwidyan.module.api.response.updateuser;

import lombok.Data;

@Data
public class UpdateSingleUserResponse {
    private int statusCode;
    private String name;
    private String job;
    private String updatedAt;
}