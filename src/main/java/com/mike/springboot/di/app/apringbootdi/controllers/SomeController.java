package com.mike.springboot.di.app.apringbootdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mike.springboot.di.app.apringbootdi.models.Product;
import com.mike.springboot.di.app.apringbootdi.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> list(){
        return productService.findAll();
    }
    
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return productService.findById(id);
    }

}
