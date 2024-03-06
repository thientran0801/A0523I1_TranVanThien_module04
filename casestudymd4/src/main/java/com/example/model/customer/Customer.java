package com.example.model.customer;

import com.example.model.contract.Contract;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, id_card, phone, email, address;
    private LocalDate day_of_birth;
    private boolean gender;
    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contractList;

    public Customer() {
    }

    public Customer(Long id, String name, String id_card, String phone, String email, String address, LocalDate day_of_birth, boolean gender, CustomerType customerType, List<Contract> contractList) {
        this.id = id;
        this.name = name;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.day_of_birth = day_of_birth;
        this.gender = gender;
        this.customerType = customerType;
        this.contractList = contractList;
    }

    public Customer(Long id, String name, String id_card, String phone, String email, String address, LocalDate day_of_birth, boolean gender, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.day_of_birth = day_of_birth;
        this.gender = gender;
        this.customerType = customerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDay_of_birth() {
        return day_of_birth;
    }

    public void setDay_of_birth(LocalDate day_of_birth) {
        this.day_of_birth = day_of_birth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
