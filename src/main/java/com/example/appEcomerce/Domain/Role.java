package com.example.appTestSpringSecurity.Domain;

import com.example.appTestSpringSecurity.util.ERole;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NonNull
    @Enumerated(EnumType.STRING)
    private ERole name;

}
