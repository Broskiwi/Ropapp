package com.duoc.ropapp.producto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.ropapp.producto.model.Producto;
import com.duoc.ropapp.producto.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> findById(@PathVariable Integer id) {
        if (productoService.findById(id).isPresent()) {
            return ResponseEntity.ok(productoService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
    }}

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id, @RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.updateProducto(producto, id));
    }
    
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findById(id);
        if  (producto.isPresent()) {
            productoService.deleteById(id);
            return producto.get().getId();
        } else {
            return -1;
        }
    }



}
