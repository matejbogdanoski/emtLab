package com.example.demo.web.rest;

import com.example.demo.models.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/product")
public class ProductApi {
    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }

    @GetMapping("/category/{categoryId}/manufacturer/{manufacturerId}")
    public List<Product> getProductByCategoryAndManufacturer(@PathVariable Long categoryId, @PathVariable Long manufacturerId){
        return productService.getProductByCategoryAndManufacturer(categoryId,manufacturerId);
    }

    @GetMapping("/category/{categoryId}/price")
    public int getPriceByCategory(@PathVariable Long categoryId){
        return productService.getPriceByCategory(categoryId);
    }

}
