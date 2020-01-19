package com.ivanwidyan.module.api.response.updateuser;

import lombok.Data;

@Data
public class UpdateUserResponse {
    private String name;
    private String job;
    private String updatedAt;
}