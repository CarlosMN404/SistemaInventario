package com.gestor.inventario.services.impl;

import com.gestor.inventario.models.Products;
import com.gestor.inventario.repositories.ProductsRepository;
import com.gestor.inventario.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }

    public Products getProductsById(Long id){
        Optional<Products> products = productsRepository.findById(id);
        if (products.isEmpty()){
            try {
                throw new Exception("Error");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return products.get();
    }

    public Products createProducts (Products products){
        products.setDate(LocalDate.now());
        return productsRepository.save(products);
    }

    public Products updateProducts (Products products, Long id){
        Products existProduct = productsRepository.findById(id).map(producto->{
            producto.setName(products.getName());
            producto.setPrice(products.getPrice());
            producto.setCategory(products.getCategory());
            return productsRepository.save(producto);
        }).orElseGet(()->productsRepository.save(products));

        return existProduct;
    }

    public void deleteProduct(Long id){
        productsRepository.deleteById(id);
    }
}
