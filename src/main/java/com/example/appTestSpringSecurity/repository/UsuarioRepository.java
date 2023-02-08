package com.example.appTestSpringSecurity.repository;

import com.example.appTestSpringSecurity.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUserName (String username);
}
