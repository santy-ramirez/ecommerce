package com.example.appEcomerce.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloSecuritycontroller {


    @GetMapping
    public String hello(){
        return "hello world security";
    }

}
