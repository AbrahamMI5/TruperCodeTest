package com.example.Truper.Model.DTO;

import com.example.Truper.Model.Ordenes;
import com.example.Truper.Model.Productos;
import com.example.Truper.Model.Sucursales;

import java.util.List;

public class OrdenCompra {
    private Ordenes ordenes;
    private List<Productos> productosList;

    public Ordenes getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(Ordenes ordenes) {
        this.ordenes = ordenes;
    }

    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }
}
