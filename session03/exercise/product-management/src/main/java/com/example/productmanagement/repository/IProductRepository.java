package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void  add(Product product);
    void  update(Product product);
    void  delete(int id);
    Product findById(int id);
    List<Product> findByName(String keyWord);
}