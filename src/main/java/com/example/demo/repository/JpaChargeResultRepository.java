package com.example.demo.repository;

import com.example.demo.models.ChargeResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaChargeResultRepository extends JpaRepository<ChargeResult, String> {
}
