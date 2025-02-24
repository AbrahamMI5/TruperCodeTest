package com.example.Truper.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericService<T, ID> {
    public ResponseEntity<T> create(T t);
    public ResponseEntity<T> findId(ID id);
    public ResponseEntity<T> update(T t);
    public ResponseEntity<Boolean> delete(ID id);
    public ResponseEntity<List<T>> getAll();
}
