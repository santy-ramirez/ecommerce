package com.example.appTestSpringSecurity.service;


import com.example.appTestSpringSecurity.Domain.Usuario;
import com.example.appTestSpringSecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Component
@Service

public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> optUser = this.usuarioRepository.findByUsername(username);
    if(optUser.isPresent()){
        return new UserDestailImpl(optUser.get());
    }

    throw new UsernameNotFoundException("no existe");
}
}