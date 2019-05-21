package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public Long id;
    @Column(name = "category_name")
    public String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
