package com.example.TiendaUno.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TiendaUno.Model.Inventario;
import com.example.TiendaUno.Repository.InventarioRepository;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> obtenerInventario() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> obtenerInventarioPorId(Integer id) {
        return inventarioRepository.findById(id);
    }

    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario actualizarInventario(Integer id, Inventario inventario) {
        inventario.setIdInventario(id);
        return inventarioRepository.save(inventario);
    }

    public void eliminarInventario(Integer id) {
        inventarioRepository.deleteById(id);
    }
}