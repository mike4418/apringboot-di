package com.mike.springboot.di.app.apringbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.mike.springboot.di.app.apringbootdi.models.Product;
@Primary
// @SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {


    private List<Product> data;

    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "Cpu Intel Core i9",850L),
            new Product(3L, "Teclado Razer Mino 60",18L),
            new Product(4L, "Motherboard Gigabyte",490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
