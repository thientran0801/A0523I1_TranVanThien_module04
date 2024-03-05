package com.example.model.customer;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(Long id, String type, List<Customer> customerList) {
        this.id = id;
        this.type = type;
        this.customerList = customerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
