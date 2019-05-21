package com.example.demo.service.impl;

import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.JpaCategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private JpaCategoryRepository repository;

    public CategoryServiceImpl(JpaCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
