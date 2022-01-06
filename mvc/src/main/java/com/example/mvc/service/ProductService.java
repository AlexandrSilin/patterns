package com.example.mvc.service;

import com.example.mvc.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Long id);
}
