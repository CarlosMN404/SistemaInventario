package com.gestor.inventario.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "price", nullable = true)
    private double price;

    @Column(name = "date", nullable = true)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Categories category;
}

