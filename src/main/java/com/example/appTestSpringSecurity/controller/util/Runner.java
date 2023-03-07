package com.example.appTestSpringSecurity.controller.util;


import com.example.appTestSpringSecurity.Domain.Role;
import com.example.appTestSpringSecurity.repository.RoleReposiory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final RoleReposiory roleReposiory;
  
    @Override
    public void run(String... args) throws Exception {
    if(this.roleReposiory.count()==0){
        this.roleReposiory.saveAll(List.of(
                new Role(ERole.ADMIN),
                new Role(ERole.READ),
                new Role(ERole.WRITE)
        ));
    }

  /* if(this.usuarioRepository.count()==0){
       this.usuarioRepository.saveAll(
               List.of(
                       new Usuario("hola","123",List.of(this.roleReposiory.findByName(ERole.WRITE).get()))
               )
       )
   }*/
}
}
