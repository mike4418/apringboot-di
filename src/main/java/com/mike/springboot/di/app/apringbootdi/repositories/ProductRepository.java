package com.mike.springboot.di.app.apringbootdi.repositories;

import java.util.List;

import com.mike.springboot.di.app.apringbootdi.models.Product;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(Long id);

}
