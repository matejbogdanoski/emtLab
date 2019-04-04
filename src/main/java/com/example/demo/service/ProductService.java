package com.example.demo.service;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {

    Product addNewProduct(String name,String desc,String imgUrl, Long manufacturerId, Long categoryId);
    List<Product> getAllProducts();
    Product update(Product product);
    void delete(Integer productId);
    Product getById(Integer productId);



}
