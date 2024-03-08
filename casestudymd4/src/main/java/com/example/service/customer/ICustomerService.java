package com.example.service.customer;

import com.example.model.customer.Customer;
import com.example.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    Page<Customer> findByKey(String keyword, Pageable pageable);
}
