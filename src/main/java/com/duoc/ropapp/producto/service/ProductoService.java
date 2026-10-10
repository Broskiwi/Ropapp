package com.duoc.ropapp.producto.service;

import com.duoc.ropapp.producto.model.Producto;
import com.duoc.ropapp.producto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(int id){
        return productoRepository.findById(id);
    }

    public Optional<Producto> findByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void  deleteById(int id) {
        productoRepository.deleteById(id);
    }

}
