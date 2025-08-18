package com.example.platzi_market.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {
    @EmbeddedId
    private CompraProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;


    //relación que tiene con compras
    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compras;

    //relación que tiene con productos
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto productos;


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompras() {
        return compras;
    }

    public void setCompras(Compra compras) {
        this.compras = compras;
    }

    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }
}
