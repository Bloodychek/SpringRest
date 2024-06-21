package org.example.springrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springrest.entity.Reader;
import org.example.springrest.repository.ReaderRepo;
import org.example.springrest.service.ReaderService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepo readerRepo;

    @Override
    public List<Reader> findAll() {
        return readerRepo.findAll();
    }

    @Override
    public Reader add(Reader reader) {
        return this.readerRepo.saveAndFlush(reader);
    }

    @Override
    public Reader update(Reader newReader, int id) {
        return readerRepo.findById(id).map(reader -> {
                    reader.setFirstName(newReader.getFirstName());
                    reader.setSecondName(newReader.getSecondName());
                    reader.setAddress(newReader.getAddress());
                    reader.setBookList(newReader.getBookList());
                    return readerRepo.saveAndFlush(reader);
                })
                .orElseGet(() -> readerRepo.saveAndFlush(newReader));
    }

    @Override
    public void delete(int id) {
        this.readerRepo.deleteById(id);
    }
}
