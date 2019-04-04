package com.example.demo.service.impl;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ManufacturerService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;
    private ManufacturerService manufacturerService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ManufacturerService manufacturerService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }


    @Override
    public Product addNewProduct(String name,String desc,String imgUrl, Long manufacturerId, Long categoryId) {
        Product p = new Product();
        p.name = name;
        p.desc =desc;
        p.imgUrl = imgUrl;
        p.manufacturer = manufacturerService.getAll().stream().filter(manufacturer -> manufacturer.id.equals(manufacturerId)).findFirst().orElse(null);
        p.category = categoryService.getAll().stream().filter(category -> category.id.equals(categoryId)).findFirst().orElse(null);
        productRepository.save(p);
        return p;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product update(Product product) {
        Product p = productRepository.findById(product.id).orElse(null);
        if (p == null) throw new RuntimeException();
        else {
            p.imgUrl = product.imgUrl;
            p.category = product.category;
            p.desc = product.desc;
            p.name = product.name;
            p.manufacturer = product.manufacturer;
            return product;
        }
    }

    @Override
    public void delete(Integer productId) {
        productRepository.delete(productId);
    }

    @Override
    public Product getById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
