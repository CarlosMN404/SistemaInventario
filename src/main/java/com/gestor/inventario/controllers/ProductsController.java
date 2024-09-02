package com.gestor.inventario.controllers;

import com.gestor.inventario.models.Products;
import com.gestor.inventario.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/productos")
    public List<Products> products(){
        return productService.getAllProducts();
    }

    @GetMapping("/producto/{id}")
    public Products getProduct(@PathVariable Long id){
        return productService.getProductsById(id);
    }

    @PostMapping("/guardar")
    public Products saveProduct(@RequestBody Products products){
        return productService.createProducts(products);
    }

    @PutMapping("/actualizar/{id}")
    public Products updateProduct(@RequestBody Products products, @PathVariable Long id){
        return productService.updateProducts(products, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
