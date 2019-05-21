package com.example.demo.repository;

import com.example.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category,Long> {
}
