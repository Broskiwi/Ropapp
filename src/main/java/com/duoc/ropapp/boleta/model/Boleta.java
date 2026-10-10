package com.duoc.ropapp.boleta.model;

import java.time.LocalDate;
import java.util.List;

import com.duoc.ropapp.pedido.model.Pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private LocalDate fecha = LocalDate.now();   // si no se envía, queda la fecha de hoy
    private double total;
    @OneToMany
    private List<Pedido> pedidos;

    public Boleta() {
    }

    public Boleta(String usuario, List<Pedido> pedidos) {
        this.usuario = usuario;
        this.pedidos = pedidos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public List<Pedido> getPedidos() { return pedidos; }
    public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
}