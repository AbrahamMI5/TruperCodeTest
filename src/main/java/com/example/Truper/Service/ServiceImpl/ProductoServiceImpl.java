package com.example.Truper.Service.ServiceImpl;

import com.example.Truper.Model.Productos;
import com.example.Truper.Service.ProductosService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Productos, Integer> implements ProductosService {
    ProductoServiceImpl(JpaRepository<Productos, Integer> repository) {
        super(repository);
    }
}
