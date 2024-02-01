package com.example.borrowbooks.service;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Page<Book> showPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> showList() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
