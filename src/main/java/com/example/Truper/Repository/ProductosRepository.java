package com.example.Truper.Repository;

import com.example.Truper.Model.Ordenes;
import com.example.Truper.Model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    List<Productos> findByOrden(Ordenes orden);
}
