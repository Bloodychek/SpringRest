package org.example.springrest.service;

import org.example.springrest.entity.Reader;

import java.util.List;

public interface ReaderService {
    List<Reader> findAll();

    Reader add(Reader reader);

    Reader update(Reader reader, int id);

    void delete(int id);
}
