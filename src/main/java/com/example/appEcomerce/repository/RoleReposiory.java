package com.example.appTestSpringSecurity.repository;

import com.example.appTestSpringSecurity.Domain.Role;
import com.example.appTestSpringSecurity.util.ERole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleReposiory extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
