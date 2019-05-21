package com.example.demo.service.impl;

import com.example.demo.models.Manufacturer;
import com.example.demo.repository.JpaManufacturerRepository;
import com.example.demo.repository.ManufacturerRepository;
import com.example.demo.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private JpaManufacturerRepository repository;


    public ManufacturerServiceImpl(JpaManufacturerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Manufacturer> getAll() {
        return repository.findAll();
    }

    @Override
    public Manufacturer getManufacturerById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
