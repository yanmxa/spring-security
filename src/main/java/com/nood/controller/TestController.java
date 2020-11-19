package com.nood.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
