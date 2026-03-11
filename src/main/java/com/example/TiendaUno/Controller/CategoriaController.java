package com.example.TiendaUno.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TiendaUno.Model.Categoria;
import com.example.TiendaUno.Service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // GET todas las categorias
    @GetMapping
    public List<Categoria> obtenerCategorias() {
        return categoriaService.obtenerCategorias();
    }

    // GET categoria por id
    @GetMapping("/{id}")
    public Optional<Categoria> obtenerCategoria(@PathVariable Integer id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    // POST crear categoria
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    // PUT actualizar categoria
    @PutMapping("/{id}")
    public Categoria actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Categoria categoria) {
        return categoriaService.actualizarCategoria(id, categoria);
    }

    // DELETE eliminar categoria
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
    }
}