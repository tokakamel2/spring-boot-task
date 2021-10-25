package com.task.task.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationalID;
    private int phoneNumber;
    private String address;

    @OneToMany
    private List<Product> product;

}
