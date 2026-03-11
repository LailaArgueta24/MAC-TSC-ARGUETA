package com.example.TiendaUno.Controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TiendaUno.Model.Producto;
import com.example.TiendaUno.Service.ProductoService;


@RestController
@RequestMapping("/tienda/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // GET todos
    @GetMapping
    public List<Producto> listarTodos() {
        return service.obtenerTodos();
    }

    // GET por id
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable int id) {
        return service.obtenerPorId(id).orElseThrow();
    }

    // POST crear
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return service.guardar(producto);
    }
    // Crear varios productos
    @PostMapping("/lote")
    public List<Producto> crearLote(@RequestBody List<Producto> productos) {
        return service.guardarTodos(productos);
    }

    // PUT actualizar
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable("id") int idProducto,
                               @RequestBody Producto producto) {
        return service.actualizar(idProducto, producto);
    }

    // DELETE  producto por id
    @DeleteMapping("/{idProducto}")
    public void eliminarProducto(@PathVariable int idProducto) {
        service.eliminar(idProducto);
    }
}