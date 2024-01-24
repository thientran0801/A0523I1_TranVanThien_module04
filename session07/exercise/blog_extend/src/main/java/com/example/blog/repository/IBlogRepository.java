package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    Page<Blog> findAll(Pageable pageable);
//    @Query("select b from Blog b where b.id = :idInput")

}
