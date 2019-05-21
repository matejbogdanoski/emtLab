package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    public Long id;
    @Column(name = "manufacturer_name")
    public String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

    public Manufacturer() {
    }

    public Manufacturer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
