package com.example.blog.service.category;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    void save(Category category);
    List<Category> showList();
    Category findById(long id);
    void delete(long id);
}