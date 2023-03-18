package com.example.appEcomerce.Domain;

import com.example.appEcomerce.util.ECategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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

}