package com.gestor.inventario.services;

import com.gestor.inventario.models.Products;
import com.gestor.inventario.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository ProductsRepository;

    public List<Products> getAllProducts(){
        return ProductsRepository.findAll();
    }

    public Products getProductsById(Long Id){
        return ProductsRepository.findById(Id).orElseThrow();
    }

    public Products CreateProducts (Products products){
        return ProductsRepository.save(products);
    }

    
}
