package com.example.customer_management.service.customer;

import com.example.customer_management.model.Customer;
import com.example.customer_management.model.Province;
import com.example.customer_management.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllAndPaging(Pageable pageable);
}