package com.example.Truper.Model.DTO;

import com.example.Truper.Model.Ordenes;
import com.example.Truper.Model.Productos;
import com.example.Truper.Model.Sucursales;

import java.util.List;

public class OrdenCompra {
    private Ordenes orden;
    private List<ProductoWOfk> productosList;

    public Ordenes getOrden() {
        return orden;
    }

    public void setOrden(Ordenes orden) {
        this.orden = orden;
    }

    public List<ProductoWOfk> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<ProductoWOfk> productosList) {
        this.productosList = productosList;
    }
}
