package com.example.Truper.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursales")
public class Sucursales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sucursalId;
    @Column(length = 50, nullable = false)
    private String nombre;

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
