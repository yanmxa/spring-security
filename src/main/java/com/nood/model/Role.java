package com.nood.model;

import java.util.HashSet;
import java.util.Set;

public class Role {

    private Integer rid;
    private String roleName;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users = new HashSet<>();

    public Integer getRid() {
        return rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<User> getUsers() {
        return users;
    }


}
