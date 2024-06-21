package org.example.springrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springrest.entity.Book;
import org.example.springrest.repository.BookRepo;
import org.example.springrest.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book add(Book book) {
        return this.bookRepo.saveAndFlush(book);
    }

    @Override
    public Book update(Book newBook, int id) {
        return bookRepo.findById(id).map(book -> {
                    book.setAuthor(newBook.getAuthor());
                    book.setBookName(newBook.getBookName());
                    book.setYearOfPublishing(newBook.getYearOfPublishing());
                    book.setDepositPrise(newBook.getDepositPrise());
                    book.setReaderList(newBook.getReaderList());
                    return bookRepo.saveAndFlush(book);
                })
                .orElseGet(() -> bookRepo.saveAndFlush(newBook));
    }

    @Override
    public void delete(int id) {
        this.bookRepo.deleteById(id);
    }
}