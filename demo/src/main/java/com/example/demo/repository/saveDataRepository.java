package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.saveData;

public interface saveDataRepository extends JpaRepository<saveData, Long>{
    
}
