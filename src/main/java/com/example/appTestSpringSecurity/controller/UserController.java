package com.example.appTestSpringSecurity.controller;


import com.example.appTestSpringSecurity.Domain.Usuario;
import com.example.appTestSpringSecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController {
@Autowired
private PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody Usuario usuario){
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    usuarioRepository.save(usuario);
   return ResponseEntity.ok("correct");
    }


}