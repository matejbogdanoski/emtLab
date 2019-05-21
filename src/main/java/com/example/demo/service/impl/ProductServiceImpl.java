package com.example.demo.service.impl;

import com.example.demo.models.Category;
import com.example.demo.models.Manufacturer;
import com.example.demo.models.Product;
import com.example.demo.repository.JpaProductRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ManufacturerService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private JpaProductRepository productRepository;
    private CategoryService categoryService;
    private ManufacturerService manufacturerService;

    public ProductServiceImpl(JpaProductRepository productRepository, CategoryService categoryService, ManufacturerService manufacturerService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }


    @Override
    public Product addNewProduct(String name,String desc,String imgUrl,int price, Long manufacturerId, Long categoryId) {
        Product p = new Product();
        p.name = name;
        p.desc =desc;
        p.imgUrl = imgUrl;
        p.price = price;
        p.manufacturers.add(
                manufacturerService.getManufacturerById(manufacturerId));
        p.categories.add(
                categoryService.getById(categoryId));
        productRepository.save(p);
        return p;
    }

    @Override
    public Product update(Product product) {
        Product p = productRepository.findById(product.id).orElse(null);
        if (p == null) throw new RuntimeException();
        else {
            p.imgUrl = product.imgUrl;
            p.categories = product.categories;
            p.desc = product.desc;
            p.name = product.name;
            p.manufacturers = product.manufacturers;
            return product;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public void delete(Long productId) {
        Product p = productRepository.findById(productId).orElse(null);
        productRepository.delete(p);
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getProductByCategory(Long categoryId) {
        Category c = categoryService.getById(categoryId);
        return productRepository.findAllByCategories(Collections.singletonList(c));
    }

    @Override
    public List<Product> getProductByCategoryAndManufacturer(Long categoryId, Long manufacturerId) {
        Category c = categoryService.getById(categoryId);
        Manufacturer m = manufacturerService.getManufacturerById(manufacturerId);
        return productRepository.findAllByCategoriesAndManufacturers(Collections.singletonList(c),Collections.singletonList(m));
    }

    @Override
    public int getPriceByCategory(Long categoryId) {
        return getProductByCategory(categoryId).stream().mapToInt(it -> it.price).sum();
    }
}
