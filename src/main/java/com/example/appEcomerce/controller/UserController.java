package com.example.appEcomerce.controller;


import com.example.appEcomerce.Domain.Usuario;
import com.example.appEcomerce.dto.ResponseUserDto;
import com.example.appEcomerce.dto.UserDto;
import com.example.appEcomerce.mapper.UserMapper;
import com.example.appEcomerce.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResponseUserDto> registerUser(@RequestBody UserDto usuario){
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
   Usuario usuaEntety =  userMapper.userDtoToUser(usuario);
    usuarioRepository.save(usuaEntety);
   return new ResponseEntity<>(userMapper.UserToResponseUserDto(usuaEntety), HttpStatus.CREATED);
    }
    
    


}