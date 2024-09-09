package com.gestor.inventario.services.impl;

import com.gestor.inventario.repositories.CategoriesRepository;
import com.gestor.inventario.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoriesRepository categoriesRepository;
}
