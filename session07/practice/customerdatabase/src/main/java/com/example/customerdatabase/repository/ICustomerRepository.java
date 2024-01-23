package com.example.customerdatabase.repository;

import com.example.customerdatabase.model.Customer;
import com.example.customerdatabase.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}