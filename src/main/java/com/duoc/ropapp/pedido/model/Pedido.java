package com.duoc.ropapp.pedido.model;

import com.duoc.ropapp.producto.model.Producto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // TODO: conectar a la interfaz de usuario
    private String usuario;
    @OneToMany
    private List<Producto> productos;

    public Pedido() {
    }

    public Pedido(String usuario, List<Producto> productos) {
        this.usuario = usuario;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
