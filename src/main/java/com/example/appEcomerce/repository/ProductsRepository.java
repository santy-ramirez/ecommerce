package com.example.appEcomerce.repository;

import com.example.appEcomerce.Domain.Producs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository< Producs,Long> {

}
