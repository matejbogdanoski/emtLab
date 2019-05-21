package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public Long id;
    @Column(name = "product_name")
    public String name;
    @Column(name = "product_desc")
    public String desc;
    @Column(name = "product_img")
    public String imgUrl;
    @Column(name = "product_price")
    public int price;
    @JsonIgnore
    @OneToMany
    public List<Category> categories = new ArrayList<>();
    @JsonIgnore
    @OneToMany
    public List<Manufacturer> manufacturers = new ArrayList<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "product_accessory",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "accessory_id"))
    public List<Accessory> accessories = new ArrayList<>();

    public Product() {
    }


}
