package com.example.TiendaUno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TiendaUno.Model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {
}