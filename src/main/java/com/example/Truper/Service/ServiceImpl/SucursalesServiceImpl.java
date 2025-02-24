package com.example.Truper.Service.ServiceImpl;

import com.example.Truper.Model.Sucursales;
import com.example.Truper.Service.SucursalesService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SucursalesServiceImpl extends GenericServiceImpl<Sucursales, Integer> implements SucursalesService {
    SucursalesServiceImpl(JpaRepository<Sucursales, Integer> repository) {
        super(repository);
    }
}
