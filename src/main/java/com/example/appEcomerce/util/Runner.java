package com.example.appEcomerce.util;


import com.example.appEcomerce.Domain.Role;
import com.example.appEcomerce.repository.RoleReposiory;
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

}
}
