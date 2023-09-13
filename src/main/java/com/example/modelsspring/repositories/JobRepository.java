package com.example.modelsspring.repositories;

import com.example.modelsspring.models.House;
import com.example.modelsspring.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface JobRepository extends CrudRepository<Job, Long> {
}
