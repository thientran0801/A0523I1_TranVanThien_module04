package com.example.borrowbooks.service;

import com.example.borrowbooks.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> showPage(Pageable pageable);

    List<Book> showList();
    Book findById(Long id);
    void save(Book book);
}
