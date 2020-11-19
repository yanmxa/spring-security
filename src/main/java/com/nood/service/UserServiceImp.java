package com.nood.service;

import com.nood.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public com.nood.model.User findByUserName(String name) {
        return userMapper.findByName(name);
    }
}
