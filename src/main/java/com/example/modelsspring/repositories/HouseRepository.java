package com.example.modelsspring.repositories;

import com.example.modelsspring.models.House;
import org.springframework.data.repository.CrudRepository;


public interface HouseRepository extends CrudRepository<House, Long> {
}
