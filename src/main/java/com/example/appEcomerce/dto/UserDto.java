package com.example.appTestSpringSecurity.dto;


import lombok.Data;

@Data
public class UserDto {
   private  String username;
   private String password;
   private String email;
   private Long authoritie;
}
