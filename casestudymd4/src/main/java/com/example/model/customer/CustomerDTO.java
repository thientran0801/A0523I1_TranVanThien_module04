package com.example.model.customer;

import com.example.model.contract.Contract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.*;
import java.util.Date;

public class CustomerDTO implements Validator {
    private Long id;
    @NotBlank(message = "The customer's name must not be empty")
    @Pattern(regexp = "^[A-Z][a-z]+(\s[A-Z][a-z]+)+$")
    private String name;
    @Pattern(regexp = "^\\d{9}(\\d{3})?$", message = "The IDcard includes 9 or 12 numbers !")
    private String id_card;
    @Pattern(regexp = "^0\\d{9}$", message = "Phone number includes 10 numbers 0xxxxxxxxx!")
    private String phone;
    @NotBlank
    @Pattern(regexp = "^.*@gmail.com$", message = "Re-enter: **********@gmail.com")
    private String email;
    @NotBlank(message = "not null")
    private String address;
    @Past
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date day_of_birth;
    private boolean gender;
    private Long customerType;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String id_card, String phone, String email, String address, Date day_of_birth, boolean gender, Long customerType) {
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

    public Date getDay_of_birth() {
        return day_of_birth;
    }

    public void setDay_of_birth(Date day_of_birth) {
        this.day_of_birth = day_of_birth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Long getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Long customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        if (customerDTO.getDay_of_birth() != null) {
            LocalDate localDate = customerDTO.getDay_of_birth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDay = LocalDate.now();
            int age = Period.between(localDate, currentDay).getYears();
            if (age < 18) {
                errors.rejectValue("day_of_birth", "", "Must be at least 18 years old!");
            } else if (age > 100) {
                errors.rejectValue("day_of_birth", "", "Age must be less than 100!");
            }
        }
    }
}
