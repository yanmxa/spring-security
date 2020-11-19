package com.nood.service;

import com.nood.model.User;

public interface UserService {

    User findByUserName(String name);
}
