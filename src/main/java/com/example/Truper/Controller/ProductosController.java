package com.example.Truper.Controller;

import com.example.Truper.Model.Productos;
import com.example.Truper.Service.GenericService;
import com.example.Truper.Service.ProductosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductosController extends GenericController<Productos, Integer> {
    protected ProductosController(ProductosService service) {
        super(service);
    }
}
