package com.nood.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nood.entity.Users;
import com.nood.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        User user = userMapper.findByName(s);
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Users users = usersMapper.selectOne(queryWrapper);

        if (users == null) {
            throw new UsernameNotFoundException("user is not exist!");
        }

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_manager123");

        return new org.springframework.security.core.userdetails.User(
                users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()),
                authorities);
    }
}
