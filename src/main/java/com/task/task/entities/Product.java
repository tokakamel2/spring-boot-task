package com.task.task.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @ManyToOne
    @JoinTable(
            name="customer_product",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Customer customer;

}
