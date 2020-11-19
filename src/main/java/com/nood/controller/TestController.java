package com.nood.controller;


import com.nood.entity.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("index")
    public String index() {
        return "hello index";
    }

    @GetMapping("hello")
    public String hello() {
        return "hello security";
    }


    @GetMapping("update")
    @Secured({"ROLE_sale", "ROLE_manager"})
    public String update() {
        return "hello update";
    }


    @GetMapping("delete")
    @PreAuthorize("hasAnyAuthority('admins')")
    public String delete() {
        return "hello delete";
    }

    @GetMapping("getAll")
    @PostAuthorize("hasAnyAuthority('admins')")
    @PostFilter("filterObject.username=='admin1'")
    public List<Users> getAll() {
        System.out.println("add ... ");
        List<Users> ans = new ArrayList<>();
        ans.add(new Users(11, "admin1", "eee"));
        ans.add(new Users(12, "admin2", "222"));
        System.out.println(ans);
        return ans;
    }
}
