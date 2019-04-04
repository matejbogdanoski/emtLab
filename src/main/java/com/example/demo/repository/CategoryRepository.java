package com.example.demo.repository;

import com.example.demo.models.Category;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private Long counter;
    private List<Category> categoryList = null;

    @PostConstruct
    public void init(){
        counter = 1L;
        categoryList = new ArrayList<>();

        Category c1 = new Category(getNextId(),"cat 1");
        Category c2 = new Category(getNextId(),"cat 2");
        Category c3 = new Category(getNextId(),"cat 3");
        categoryList.add(c1);
        categoryList.add(c2);
        categoryList.add(c3);
    }

    public List<Category> findAllCategories(){
        return categoryList;
    }

    public Category save(Category category){
        category.id = getNextId();
        categoryList.add(category);
        return category;
    }

    public void delete(Long categoryId){
        categoryList.removeIf(category -> category.id.equals(categoryId));
    }

    public Optional<Category> findById(Long categoryId){
        return categoryList.stream().filter(category -> category.id.equals(categoryId)).findAny();
    }

    private Long getNextId() {
        return counter++;
    }

}
