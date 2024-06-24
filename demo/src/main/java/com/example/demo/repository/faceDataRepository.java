package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.faceData;
//import java.util.List;


public interface faceDataRepository extends JpaRepository<faceData, Long> {

    	faceData findByUsername(String username);

    List<faceData> findByUsernameContaining(String username);
    // List<faceData> findByPhoneticContaining(String phonetic);
}
