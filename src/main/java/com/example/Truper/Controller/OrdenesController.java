package com.example.Truper.Controller;

import com.example.Truper.Model.DTO.OrdenCompra;
import com.example.Truper.Model.Ordenes;
import com.example.Truper.Model.Sucursales;
import com.example.Truper.Service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/ordenes")
public class OrdenesController extends GenericController<Ordenes, Integer> {
    @Autowired
    OrdenesService ordenesService;

    protected OrdenesController(OrdenesService service) {
        super(service);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrdenCompra> createOrden(@RequestBody OrdenCompra ordenCompra){
        return ordenesService.createOrden(ordenCompra);
    }

    @GetMapping("/findOrdenCompra/{id}")
    public ResponseEntity<OrdenCompra> createOrden(@PathVariable Integer id){
        return ordenesService.getOrden(id);
    }
}
