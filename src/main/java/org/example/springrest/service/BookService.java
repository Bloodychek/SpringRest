package org.example.springrest.service;

import org.example.springrest.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book add(Book book);

    Book update(Book book, int id);

    void delete(int id);
}
