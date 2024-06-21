package org.example.springrest.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springrest.entity.Reader;
import org.example.springrest.service.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reader/")
public class ReaderController {
    private final ReaderService readerService;

    @GetMapping
    public List<Reader> findAll() {
        return readerService.findAll();
    }

    @PostMapping
    public Reader add(@RequestBody Reader newReader) {
        return readerService.add(newReader);
    }

    @PutMapping("{id}")
    public Reader update(@RequestBody Reader newReader, @PathVariable int id) {
        return readerService.update(newReader, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        readerService.delete(id);
    }
}
