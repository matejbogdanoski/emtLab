package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accessories")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessory_id")
    public Long id;
    @Column(name = "accessory_name")
    public String name;
    @ManyToMany(mappedBy = "accessories")
    public List<Product> products = new ArrayList<>();

    public Accessory() {
    }

    public Accessory(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
