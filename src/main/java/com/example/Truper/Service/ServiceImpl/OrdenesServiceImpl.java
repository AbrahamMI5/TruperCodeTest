package com.example.Truper.Service.ServiceImpl;

import com.example.Truper.Model.DTO.OrdenCompra;
import com.example.Truper.Model.DTO.ProductoWOfk;
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

import java.util.ArrayList;
import java.util.List;

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
            Ordenes orden = ordenCompra.getOrden();
            if(orden != null){
                orden = ordenesRepository.save(orden);
                for(ProductoWOfk productoWOfk:ordenCompra.getProductosList()){
                    Productos productos = new Productos();
                    productos.setCodigo(productoWOfk.getCodigo());
                    productos.setDescripcion(productoWOfk.getDescripcion());
                    productos.setPrecio(productoWOfk.getPrecio());
                    productos.setOrden(orden);
                    productosRepository.save(productos);
                }
            }else{
                throw new Exception("No existe orden");
            }
            return new ResponseEntity<>(ordenCompra, HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<OrdenCompra> getOrden(Integer id) {
        try{
            OrdenCompra ordenCompra = new OrdenCompra();
            Ordenes orden = new Ordenes();
            orden = ordenesRepository.findById(id).get();
            ordenCompra.setOrden(orden);
            List<Productos> productosList = new ArrayList<>();
            List<ProductoWOfk> productosWOfkList = new ArrayList<>();
            productosList = productosRepository.findByOrden(orden);
            for(Productos productos:productosList){
                ProductoWOfk productoWOfk = new ProductoWOfk();
                productoWOfk.setCodigo(productos.getCodigo());
                productoWOfk.setDescripcion(productos.getDescripcion());
                productoWOfk.setPrecio(productos.getPrecio());
                productosWOfkList.add(productoWOfk);
            }
            ordenCompra.setProductosList(productosWOfkList);
            return new ResponseEntity<>(ordenCompra, HttpStatus.OK);

        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
