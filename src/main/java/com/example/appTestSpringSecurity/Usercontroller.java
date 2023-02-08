package com.example.appTestSpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class Usercontroller {

    @GetMapping
    public String hoal(){
        return "ello world";
    }

}
