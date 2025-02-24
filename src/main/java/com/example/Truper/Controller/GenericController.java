package com.example.Truper.Controller;

import com.example.Truper.Service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class GenericController<T, ID> {
    protected final GenericService<T, ID> service;

    protected GenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        return service.findId(id);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<T>> findAll() {
        return service.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<T> create(@RequestBody T entity) {
        return service.create(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<T> update(@RequestBody T entity) {
        return service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ID id) {
        return service.delete(id);
    }
}
