package com.example.demo.service;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {

    Product addNewProduct(String name,String desc,String imgUrl,int price , Long manufacturerId, Long categoryId);
    List<Product> getAllProducts();
    Product update(Product product);
    void delete(Long productId);
    Product getById(Long productId);
    List<Product> getProductByCategory(Long categoryId);
    List<Product> getProductByCategoryAndManufacturer(Long categoryId, Long manufacturerId);
    int getPriceByCategory(Long categoryId);


}
