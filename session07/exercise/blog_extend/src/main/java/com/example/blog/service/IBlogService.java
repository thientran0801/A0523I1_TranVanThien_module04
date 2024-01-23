package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    void add(Blog blog);
    void update(Blog blog);
    List<Blog> showList();
    Blog findById(long id);
    void delete(long id);

}
