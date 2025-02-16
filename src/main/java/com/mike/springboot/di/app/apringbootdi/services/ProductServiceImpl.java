package com.mike.springboot.di.app.apringbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.core.env.Environment;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.springboot.di.app.apringbootdi.models.Product;
import com.mike.springboot.di.app.apringbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    // @Autowired
    // private Environment environment;

    @Value("${config.tax.price}")
    private Double tax;

    private ProductRepository productRepository;

    //This is other way to inject the product repository, through set method, but it still needs to have the Autowired anotation
    // @Autowired
    // public void setProductRepository(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }
    
        //With the constructor also it's possible to inject but in this case the Autowired annotation is not required.
    public ProductServiceImpl(@Qualifier("productRepositoryJson") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public List<Product> findAll(){
        
        return productRepository.findAll().stream().map(p -> {
            // Double priceTax = p.getPrice() * environment.getProperty("config.tax.price", Double.class);
            Double priceTax = p.getPrice() * tax;
            // Product newProd = new Product(p.getId(),p.getName(),priceImp.longValue());
            Product newProd =  (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
             return newProd;
  
           
        }).collect(Collectors.toList());
    }

   
    @Override
    public Product findById(Long id){
        return productRepository.findById(id);
    }

    
}
