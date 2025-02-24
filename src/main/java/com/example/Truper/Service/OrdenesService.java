package com.example.Truper.Service;

import com.example.Truper.Model.DTO.OrdenCompra;
import com.example.Truper.Model.Ordenes;
import com.example.Truper.Model.Sucursales;
import org.springframework.http.ResponseEntity;

public interface OrdenesService extends GenericService<Ordenes, Integer> {
    ResponseEntity<OrdenCompra> createOrden(OrdenCompra ordenCompra);
    ResponseEntity<OrdenCompra> getOrden(Sucursales sucursal);
}
