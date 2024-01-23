package com.example.customer_management.repository;

import com.example.customer_management.model.Customer;
import com.example.customer_management.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}