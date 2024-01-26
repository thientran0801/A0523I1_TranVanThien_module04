package com.example.validationform_sign_up.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//@Entity
public class User {
/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
    @Size(min = 5, max = 45, message = "Enter only 5 to 45 characters")
    private String firstname;
    @Size(min = 5, max = 45, message = "Enter only 5 to 45 characters")
    private String lastname;
    @Pattern(regexp = "^0\\d{9,10}$")
    private String phoneNumber;
    @Min(value = 18)
    private int age;
    @Pattern(regexp = "^[A-Za-z0-9]+@gmail.com$")
    private String email;
    public User() {
    }

    public User(String firstname, String lastname, String phoneNumber, int age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}