package com.duoc.ropapp.sucursal.model;

import com.duoc.ropapp.producto.model.Producto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    private String ciudad;
    @OneToMany(mappedBy = "sucursal")
    List<Producto> productos;

    public Sucursal() {
    }

    public Sucursal(String nombre, String direccion, String ciudad, List<Producto> productos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
