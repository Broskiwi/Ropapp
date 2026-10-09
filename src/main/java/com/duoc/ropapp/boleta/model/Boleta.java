package com.duoc.ropapp.boleta.model;

import com.duoc.ropapp.pedido.model.Pedido;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // TODO: conectar a la interfaz de usuario
    private String usuario;
    @OneToMany
    private List<Pedido> pedidos;

    public Boleta() {
    }

    public Boleta(String usuario, List<Pedido> pedidos) {
        this.usuario = usuario;
        this.pedidos = pedidos;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void getPedidos(List<Pedido> productos) {
        this.pedidos = productos;
    }
}
