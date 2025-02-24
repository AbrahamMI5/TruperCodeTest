package com.example.Truper.Service.ServiceImpl;

import com.example.Truper.Model.DTO.OrdenCompra;
import com.example.Truper.Model.Ordenes;
import com.example.Truper.Model.Productos;
import com.example.Truper.Model.Sucursales;
import com.example.Truper.Repository.OrdenesRepository;
import com.example.Truper.Repository.ProductosRepository;
import com.example.Truper.Repository.SucursalesRepository;
import com.example.Truper.Service.OrdenesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrdenesServiceImpl  extends GenericServiceImpl<Ordenes, Integer> implements OrdenesService {
    private static final Logger log = LogManager.getLogger(OrdenesServiceImpl.class);

    OrdenesServiceImpl(JpaRepository<Ordenes, Integer> repository) {
        super(repository);
    }

    @Autowired
    OrdenesRepository ordenesRepository;
    @Autowired
    SucursalesRepository sucursalesRepository;
    @Autowired
    ProductosRepository productosRepository;

    @Override
    public ResponseEntity<OrdenCompra> createOrden(OrdenCompra ordenCompra) {
        try{
            Ordenes ordenes = ordenCompra.getOrdenes();
            ordenesRepository.save(ordenes);

            for(Productos productos:ordenCompra.getProductosList()){
                productosRepository.save(productos);
            }
            return new ResponseEntity<>(ordenCompra, HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<OrdenCompra> getOrden(Sucursales sucursal) {
        return null;
    }
}
