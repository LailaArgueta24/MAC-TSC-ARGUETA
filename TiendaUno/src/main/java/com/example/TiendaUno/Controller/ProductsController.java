package com.example.TiendaUno.Controller;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TiendaUno.Model.Products;
import com.example.TiendaUno.Service.ProductService;


@RestController
@RequestMapping("/tienda/productos")
public class ProductsController {

    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }

    // GET todos
    @GetMapping
    public List<Products> listarTodos() {
        return service.obtenerTodos();
    }

    // GET por id
    @GetMapping("/{id}")
    public Products obtener(@PathVariable int id) {
        return service.obtenerPorId(id);
    }

    // POST crear
    @PostMapping
    public Products crear(@RequestBody @NonNull Products producto) {
        return service.guardar(producto);
    }
    // Crear varios productos
    @PostMapping("/lote")
    public List<Products> crearLote(@RequestBody @NonNull List<Products> productos) {
        return service.guardarTodos(productos);
    }

    // PUT actualizar
    @PutMapping("/{id}")
    public Products actualizar(@PathVariable("id") int idProducto,
                               @RequestBody Products producto) {
        return service.actualizar(idProducto, producto);
    }

    // DELETE  producto por id
    @DeleteMapping("/{idProducto}")
    public void eliminarProducto(@PathVariable int idProducto) {
        service.eliminar(idProducto);
    }
}