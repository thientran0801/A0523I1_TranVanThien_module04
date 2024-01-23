package com.example.customerdatabase.service.customer;

import com.example.customerdatabase.model.Customer;
import com.example.customerdatabase.model.Province;
import com.example.customerdatabase.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}