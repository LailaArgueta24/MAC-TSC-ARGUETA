package com.example.TiendaUno.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TiendaUno.Model.Categoria;
import com.example.TiendaUno.Repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Obtener todas las categorias
    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener categoria por id
    public Optional<Categoria> obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Guardar categoria
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar categoria
    public Categoria actualizarCategoria(Integer id, Categoria categoria) {
        categoria.setIdCategoria(id);
        return categoriaRepository.save(categoria);
    }

    // Eliminar categoria
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}