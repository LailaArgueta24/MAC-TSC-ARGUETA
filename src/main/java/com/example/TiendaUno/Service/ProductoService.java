package com.example.TiendaUno.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TiendaUno.Model.Producto;
import com.example.TiendaUno.Repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerPorId(int idProducto) {
        return repository.findById(idProducto);
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> guardarTodos(List<Producto> productos) {
        return repository.saveAll(productos);
    }

    public Producto actualizar(int idProducto, Producto productoActualizado) {
        Producto producto = repository.findById(idProducto).orElseThrow();
        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setDescripcion(productoActualizado.getDescripcion());
        return repository.save(producto);
    }
    public void eliminar(int idProducto) {
        repository.deleteById(idProducto);
    }
}