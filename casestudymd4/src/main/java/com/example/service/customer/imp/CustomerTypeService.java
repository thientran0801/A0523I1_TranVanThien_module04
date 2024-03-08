package com.example.service.customer.imp;

import com.example.model.customer.CustomerType;
import com.example.repository.customer.CustomerTypeRepository;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> showList() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Page<CustomerType> showList(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (customerTypeRepository.existsById(id)) {
            customerTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public Optional<CustomerType> findById(Long id) {
        return customerTypeRepository.findById(id);
    }
}
