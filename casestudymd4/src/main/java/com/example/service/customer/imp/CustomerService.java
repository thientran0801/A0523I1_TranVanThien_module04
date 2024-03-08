package com.example.service.customer.imp;

import com.example.model.customer.Customer;
import com.example.repository.customer.CustomerRepository;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> showList() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> showList(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> findByKey(String keyword, Pageable pageable) {
        return customerRepository.findBykey("%" + keyword + "%", pageable);
    }

}
