package com.ivanwidyan.module.api.response.getuser;

import lombok.Data;

@Data
public class UserData {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
