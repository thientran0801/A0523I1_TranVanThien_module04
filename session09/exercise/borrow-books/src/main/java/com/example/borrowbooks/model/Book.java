package com.example.borrowbooks.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    @Convert(converter = CodeBorrow.class)
    List<String> listCodeBorrow;
    public Book() {
    }

    public Book(Long id, String name, int quantity, List<String> listCodeBorrow) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.listCodeBorrow = listCodeBorrow;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getListCodeBorrow() {
        return listCodeBorrow;
    }

    public void setListCodeBorrow(List<String> listCodeBorrow) {
        this.listCodeBorrow = listCodeBorrow;
    }
}
