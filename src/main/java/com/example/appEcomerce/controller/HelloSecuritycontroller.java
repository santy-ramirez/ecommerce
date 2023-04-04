package com.example.appEcomerce.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("hello")
public class HelloSecuritycontroller {


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String hello(){
        return "hello world security Sr. Admin";
    }
    @GetMapping("user")
    @PreAuthorize("hasAuthority('READ')")
    public String helloUser(){
        return "hello world security Sr. USER";
    }

}
