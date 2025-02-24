package com.example.Truper.Repository;

import com.example.Truper.Model.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Integer> {
}
