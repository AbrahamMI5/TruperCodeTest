package com.example.Truper.Repository;

import com.example.Truper.Model.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalesRepository extends JpaRepository<Sucursales, Integer> {
}
