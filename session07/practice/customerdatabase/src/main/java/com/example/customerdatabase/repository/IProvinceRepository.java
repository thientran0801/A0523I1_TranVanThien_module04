package com.example.customerdatabase.repository;

import com.example.customerdatabase.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
}