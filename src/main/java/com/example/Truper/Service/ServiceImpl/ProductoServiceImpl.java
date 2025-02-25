package com.example.Truper.Service.ServiceImpl;

import com.example.Truper.Model.Productos;
import com.example.Truper.Repository.ProductosRepository;
import com.example.Truper.Service.ProductosService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Productos, Integer> implements ProductosService {


    ProductoServiceImpl(ProductosRepository repository) {
        super(repository);
    }
}
