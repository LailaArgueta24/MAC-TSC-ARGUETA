package com.example.TiendaUno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TiendaUno.Model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findByNombre(String nombre);
    Producto findByIdProducto(Integer idProducto);
    //List<Producto> findByHabilitado(Boolean habilitado);
}