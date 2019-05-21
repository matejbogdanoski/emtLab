package com.example.demo.repository;

import com.example.demo.models.Category;
import com.example.demo.models.Manufacturer;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCategories(List<Category> categories);
    List<Product> findAllByCategoriesAndManufacturers(List<Category> categories, List<Manufacturer> manufacturers);
}
