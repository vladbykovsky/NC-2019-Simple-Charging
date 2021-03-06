package com.example.backend.service;

import com.example.backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
    Optional<Product> findAllByName(String name);
    Optional<Product> findById(int id);
    Product findByName(String name);
    Optional<Product> findByNameStartingWith(String str);
    Product saveProduct(Product product);
    void deleteProduct(int id);

}
