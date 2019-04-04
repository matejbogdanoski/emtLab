package com.example.demo.repository;

import com.example.demo.models.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {

    private Long counter;
    private List<Manufacturer> manufacturerList;

    @PostConstruct
    public void init(){
        counter = 1L;
        manufacturerList = new ArrayList<>();

        Manufacturer m1 = new Manufacturer(getNextId(),"man 1");
        Manufacturer m2 = new Manufacturer(getNextId(),"man 2");
        Manufacturer m3 = new Manufacturer(getNextId(),"man 3");

        manufacturerList.add(m1);
        manufacturerList.add(m2);
        manufacturerList.add(m3);

    }

    public List<Manufacturer> findAllManufacturers(){
        return manufacturerList;
    }

    public Manufacturer save(Manufacturer manufacturer){
        manufacturer.id = getNextId();
        manufacturerList.add(manufacturer);
        return manufacturer;
    }

    public void delete(Long manufacturerId){
        manufacturerList.removeIf(manufacturer -> manufacturer.id.equals(manufacturerId));
    }

    public Optional<Manufacturer> getManufacturerById(Long manufacturerId){
        return manufacturerList.stream().filter(manufacturer -> manufacturer.id.equals(manufacturerId)).findAny();
    }


    private Long getNextId() {
        return counter++;
    }



}
