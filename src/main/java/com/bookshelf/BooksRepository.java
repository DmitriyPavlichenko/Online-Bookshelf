package com.bookshelf;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByName(String name);
}