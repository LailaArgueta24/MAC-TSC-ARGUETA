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

import com.example.TiendaUno.Model.Inventario;
import com.example.TiendaUno.Service.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> obtenerInventario() {
        return inventarioService.obtenerInventario();
    }

    @GetMapping("/{id}")
    public Optional<Inventario> obtenerInventarioPorId(@PathVariable Integer id) {
        return inventarioService.obtenerInventarioPorId(id);
    }

    @PostMapping
    public Inventario crearInventario(@RequestBody Inventario inventario) {
        return inventarioService.guardarInventario(inventario);
    }

    @PutMapping("/{id}")
    public Inventario actualizarInventario(
            @PathVariable Integer id,
            @RequestBody Inventario inventario) {

        return inventarioService.actualizarInventario(id, inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminarInventario(@PathVariable Integer id) {
        inventarioService.eliminarInventario(id);
    }
}