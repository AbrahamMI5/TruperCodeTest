package com.example.Truper.Service.ServiceImpl;

import com.example.Truper.Service.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    private static final Logger log = LogManager.getLogger(GenericServiceImpl.class);
    protected final JpaRepository<T, ID> repository;

    GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public ResponseEntity<T> create(T t) {
        try{
            return new ResponseEntity<>(repository.save(t), HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<T> update(T t) {
        try{
            return new ResponseEntity<>(repository.save(t), HttpStatus.CREATED);
        }catch (Exception e){
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Boolean> delete(ID id) {
        try{
            repository.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            log.error(e);
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<T> findId(ID id) {
        try{
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        }catch (Exception e){
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<T>> getAll() {
        try{
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
