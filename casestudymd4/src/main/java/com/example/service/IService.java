package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IService<E> {
    List<E> showList();
    Page<E> showList(Pageable pageable);
    boolean delete(Long id);
    void save(E e);
    Optional<E> findById(Long id);
    }