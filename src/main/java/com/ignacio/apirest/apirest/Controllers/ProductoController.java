package com.ignacio.apirest.apirest.Controllers;

import com.ignacio.apirest.apirest.Entities.Producto;
import com.ignacio.apirest.apirest.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping
    public List<Producto> getAllProducto(){
        return productoRepository.findAll();
    };

    @GetMapping("/{id}")
    public Producto getProductByID(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró un producto con el ID: " + id));
    };

    @PostMapping
    public Producto CreateProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    };

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró un producto con el ID: " + id));

        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());


        return productoRepository.save(producto);
    };

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró un producto con el ID: " + id));

        productoRepository.delete(producto);

        return "El producto con id " + id + " fue eliminado correctamentes";
    }

}
