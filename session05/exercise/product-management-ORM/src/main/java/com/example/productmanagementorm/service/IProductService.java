package com.example.productmanagementorm.service;

import com.example.productmanagementorm.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void  add(Product product);
    void  update(Product product);
    void  delete(int id);
    Product findById(int id);
    List<Product> findByName(String keyWord);
}
