package com.example.TiendaUno.Repository;

import java.util.List;

import com.example.TiendaUno.Model.Products;

public interface ProductRepository {

    List<Products> findAll();

    Products findByIdProducto(int idProducto);

    Products save(Products producto);

    List<Products> saveAll(Iterable<Products> productos);

    void deleteByIdProduct(int idProducto);
}