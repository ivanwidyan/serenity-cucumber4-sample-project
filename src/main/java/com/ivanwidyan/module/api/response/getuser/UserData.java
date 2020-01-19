package com.ivanwidyan.module.api.response.getuser;

import lombok.Data;

@Data
public class UserData {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
