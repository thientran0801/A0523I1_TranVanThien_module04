package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findByKey(String key, Pageable pageable) {
        return blogRepository.findByKey("%" + key + "%", pageable);
    }

    @Override
    public List<Blog> showList() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        blogRepository.deleteById(id);
    }
}
