package com.example.TiendaUno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TiendaUno.Model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
}