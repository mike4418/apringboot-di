package com.mike.springboot.di.app.apringbootdi.repositories;

import java.util.Collections;
import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.mike.springboot.di.app.apringbootdi.models.Product;

//When there is more than one implementation, this Primary annotation is required to identify which of those implementation we want to use at first.
@Repository
public class ProductRepositoryFood implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Monitos Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id,"Monitos Asus 27", 600L);
    }

}
