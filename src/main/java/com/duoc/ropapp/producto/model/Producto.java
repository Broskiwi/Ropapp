package com.duoc.ropapp.producto.model;

import com.duoc.ropapp.pedido.model.Pedido;
import com.duoc.ropapp.sucursal.model.Sucursal;
import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;
    @ManyToOne
    @JoinColumn(name = "pedidos")
    private Pedido pedido;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, Sucursal sucursal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sucursal = sucursal;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
