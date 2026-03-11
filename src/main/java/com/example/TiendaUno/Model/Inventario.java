package com.example.TiendaUno.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_INVENTARIO")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NID_INVENTARIO")
    private Integer idInventario;

    @ManyToOne
    @JoinColumn(name = "NID_PRODUCTO")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "NID_ALMACEN")
    private Almacen almacen;

    @Column(name = "NSTOCK")
    private Integer stock;

    @Column(name = "BHABILITADO")
    private Boolean habilitado;

    @Column(name = "DFECHA_ALTA")
    private LocalDateTime fechaAlta;

    @Column(name = "DFECHA_BAJA")
    private LocalDateTime fechaBaja;

    public Inventario() {}

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Integer getnStock() {
        return stock;
    }

    public void setnStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getbHabilitado() {
        return habilitado;
    }

    public void setbHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public LocalDateTime getdFechaAlta() {
        return fechaAlta;
    }

    public void setdFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getdFechaBaja() {
        return fechaBaja;
    }

    public void setdFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}