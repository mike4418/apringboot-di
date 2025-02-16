package com.mike.springboot.di.app.apringbootdi.services;

import java.util.List;

import com.mike.springboot.di.app.apringbootdi.models.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

}
