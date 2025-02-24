package com.example.Truper.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "ordenes")
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordenId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "sucursales", referencedColumnName = "sucursalId", nullable = false)
    private Sucursales sucursal;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private int total;

    public Integer getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Integer ordenId) {
        this.ordenId = ordenId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }
}
