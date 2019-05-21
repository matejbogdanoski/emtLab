package com.example.demo.repository;

import com.example.demo.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
