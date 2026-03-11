package com.example.TiendaUno.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TiendaUno.Model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
