package com.gestor.inventario.services;

import com.gestor.inventario.models.Products;
import java.util.List;

public interface ProductService {

    public List<Products> getAllProducts();

    public Products getProductsById(Long Id);

    public Products createProducts (Products products);

    public Products updateProducts (Products products, Long id);

    public void deleteProduct(Long id);
}
