package com.example.demo.repository;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private Integer counter;
    private List<Product> productsList = null;
    private CategoryRepository categoryRepository;
    private ManufacturerRepository manufacturerRepository;

    public ProductRepository(CategoryRepository categoryRepository, ManufacturerRepository manufacturerRepository) {
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @PostConstruct
    public void init(){

        counter = 1;
        productsList = new ArrayList<>();

        Product p1 = new Product();
        p1.id = getNextId();
        p1.name = "product name 1";
        p1.desc = "product desc 1";
        p1.imgUrl = "https://www.leehealthwellbeing.com.au/wp-content/uploads/2016/02/graphic_product_tangible.png";
        p1.category = categoryRepository.findById(2L).get();
        p1.manufacturer = manufacturerRepository.getManufacturerById(2L).get();
        productsList.add(p1);

        Product p2 = new Product();
        p2.id = getNextId();
        p2.name = "product name 2";
        p2.desc = "product desc 2";
        p2.imgUrl = "https://www.leehealthwellbeing.com.au/wp-content/uploads/2016/02/graphic_product_tangible.png";
        p2.category = categoryRepository.findById(1L).get();
        p2.manufacturer = manufacturerRepository.getManufacturerById(1L).get();
        productsList.add(p2);

    }

    public List<Product> findAllProducts(){
        return this.productsList;
    }

    public Product save(Product product){
        product.id = getNextId();
        productsList.add(product);
        return product;
    }

    public void delete(Integer productId){
        productsList.removeIf(product -> product.id.equals(productId));
    }

    public Optional<Product> findById(Integer productId){
        return productsList.stream().filter(product -> product.id.equals(productId)).findAny();
    }

    private Integer getNextId() {
        return counter++;
    }


}
