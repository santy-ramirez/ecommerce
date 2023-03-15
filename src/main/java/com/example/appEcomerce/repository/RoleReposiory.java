package com.example.appEcomerce.repository;

import com.example.appEcomerce.Domain.Role;
import com.example.appEcomerce.util.ERole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleReposiory extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
