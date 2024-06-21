package org.example.springrest.repository;

import org.example.springrest.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepo extends JpaRepository<Reader, Integer> {
}
