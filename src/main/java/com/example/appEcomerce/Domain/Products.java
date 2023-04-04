package com.example.appEcomerce.Domain;

import com.example.appEcomerce.util.ECategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Description;
    @Enumerated(EnumType.STRING)
    private ECategory category;
    private LocalDate dateRegister;
    private LocalDate dateUpdate;
    private Boolean softDelete;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_users",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Usuario> users = new ArrayList<>();



}
