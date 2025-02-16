package com.mike.springboot.di.app.apringbootdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.mike.springboot.di.app.apringbootdi.repositories.ProductRepository;
import com.mike.springboot.di.app.apringbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:json/product.json")
    private Resource resource;


    @Bean
    @Primary
    ProductRepository productRepositoryJson(){
        return  new ProductRepositoryJson();
    }

}
