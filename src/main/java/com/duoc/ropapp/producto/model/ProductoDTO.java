package com.duoc.ropapp.producto.model;

public class ProductoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer sucursalRef;

    public ProductoDTO() {
    }

    public ProductoDTO(Integer id, String nombre, String descripcion, Integer sucursalRef) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sucursalRef = sucursalRef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSucursalRef() {
        return sucursalRef;
    }

    public void setSucursalRef(Integer sucursalRef) {
        this.sucursalRef = sucursalRef;
    }
}
