package com.example.appEcomerce.service;

import com.example.appEcomerce.Domain.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor

public class SecurityAutority implements GrantedAuthority {
    private final Role role;
    @Override
    public String getAuthority() {
        return role.getName().toString();
    }
}
