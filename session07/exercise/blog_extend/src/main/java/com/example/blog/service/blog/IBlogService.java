package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void save(Blog blog);

    //    void update(Blog blog);
    List<Blog> showList();
    Page<Blog> findAll(Pageable pageable);

    Blog findById(long id);

    void delete(long id);

}
