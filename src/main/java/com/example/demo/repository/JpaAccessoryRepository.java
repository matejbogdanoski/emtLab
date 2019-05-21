package com.example.demo.repository;

import com.example.demo.models.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAccessoryRepository extends JpaRepository<Accessory,Long> {
}
