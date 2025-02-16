package com.mike.springboot.di.app.apringbootdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// import com.fasterxml.jackson.core.exc.StreamReadExt
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mike.springboot.di.app.apringbootdi.models.Product;

public class ProductRepositoryJson implements ProductRepository{


    private List<Product> list;

    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson(Resource resource){
        readValueJson(resource);

    }

    private void readValueJson(Resource resource){
        ObjectMapper oMapper = new ObjectMapper();

        try {
            list = Arrays.asList(oMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
       
    }

   

    @Override
    public Product findById(Long id) {
       return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }



}
