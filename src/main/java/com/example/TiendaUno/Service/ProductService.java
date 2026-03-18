package com.example.TiendaUno.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TiendaUno.Model.Products;
import com.example.TiendaUno.Repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Products> obtenerTodos() {
        return repository.findAll();
    }

    public Products obtenerPorId(int idProducto) {
        return repository.findByIdProducto(idProducto);
    }

    public Products guardar(Products producto) {
        return repository.save(producto);
    }

    public List<Products> guardarTodos(List<Products> productos) {
        return repository.saveAll(productos);
    }

    public Products actualizar(int idProducto, Products productoActualizado) {
        Products producto = repository.findByIdProducto(idProducto);
        producto.setNameProduct(productoActualizado.getNameProduct());
        producto.setPrice(productoActualizado.getPrice());
        producto.setStock(productoActualizado.getStock());
        return repository.save(producto);
    }
    public void eliminar(int idProducto) {
        repository.deleteByIdProduct(idProducto); 
    }
}