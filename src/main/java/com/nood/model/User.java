package com.nood.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Integer uid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public Integer getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
