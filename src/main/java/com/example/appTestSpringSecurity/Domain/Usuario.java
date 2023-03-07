package com.example.appTestSpringSecurity.Domain;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String username;

    private String email;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> authorities = new ArrayList<>();



}
