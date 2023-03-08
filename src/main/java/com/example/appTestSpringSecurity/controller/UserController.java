package com.example.appTestSpringSecurity.controller;


import com.example.appTestSpringSecurity.Domain.Usuario;
import com.example.appTestSpringSecurity.dto.UserDto;
import com.example.appTestSpringSecurity.mapper.UserMapper;
import com.example.appTestSpringSecurity.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class UserController {


private final PasswordEncoder passwordEncoder;
    
  private final UsuarioRepository usuarioRepository;
    
   private final UserMapper userMapper;

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto usuario){
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
   Usuario usuaEntety =  userMapper.userDtoToUser(usuario);
    usuarioRepository.save(usuaEntety);
   return ResponseEntity.ok("correct");
    }
    
    


}