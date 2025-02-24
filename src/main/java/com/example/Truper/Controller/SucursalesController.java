package com.example.Truper.Controller;

import com.example.Truper.Model.Sucursales;
import com.example.Truper.Service.GenericService;
import com.example.Truper.Service.ServiceImpl.GenericServiceImpl;
import com.example.Truper.Service.SucursalesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sucursales")
public class SucursalesController extends GenericController<Sucursales, Integer> {
    protected SucursalesController(SucursalesService service) {
        super(service);
    }
}
