package com.duoc.ropapp.producto.service;

import com.duoc.ropapp.producto.model.Producto;
import com.duoc.ropapp.producto.model.ProductoDTO;
import com.duoc.ropapp.producto.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public Producto updateProducto(ProductoDTO producto, Integer id) {
        Optional<Producto> ogProducto = productoRepository.findById(id);
        if(ogProducto.isEmpty()){
            throw new EntityNotFoundException("Producto not found");
        }
        if(Objects.nonNull(producto.getNombre()) && !"".equalsIgnoreCase(producto.getNombre())) {
            ogProducto.get().setNombre(producto.getNombre());
        }
        if(Objects.nonNull(producto.getDescripcion()) && !"".equalsIgnoreCase(producto.getDescripcion())) {
            ogProducto.get().setDescripcion(producto.getDescripcion());
        }
        return productoRepository.save(ogProducto.get());
    }
}
