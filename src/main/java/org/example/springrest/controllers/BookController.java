package org.example.springrest.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springrest.entity.Book;
import org.example.springrest.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book/")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @PostMapping
    public Book add(@RequestBody Book newBook) {
        return bookService.add(newBook);
    }

    @PutMapping("{id}")
    public Book update(@RequestBody Book newBook, @PathVariable int id) {
        return bookService.update(newBook, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}