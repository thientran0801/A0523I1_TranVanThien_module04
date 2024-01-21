package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public void add(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        Optional<Blog> blogOptional = blogRepository.findById(blog.getId());
        Blog oldBlog;
        if (blogOptional.isPresent()) {
            oldBlog = blogOptional.get();
        } else {
            return;
        }

        oldBlog.setDateCreate(blog.getDateCreate());
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setAuthor(blog.getAuthor());
        oldBlog.setContent(blog.getContent());
        oldBlog.setImage(blog.getImage());

        blogRepository.save(oldBlog);
    }

    @Override
    public List<Blog> showList() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(long id) {
      Optional<Blog> blogOptional = blogRepository.findById(id);
      if (blogOptional.isPresent()) {
          Blog blog = blogOptional.get();
          return blog;
      }
      return null;
    }

    @Override
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

}
