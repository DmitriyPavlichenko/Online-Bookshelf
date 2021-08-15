package com.bookshelf;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private static BooksRepository repository;

    public BooksService(BooksRepository repository) {
        BooksService.repository = repository;
    }

    public static void addBook(Book book) {
        Optional<Book> bookFromRepo = repository.findBookByName(book.getName());
        if (bookFromRepo.isPresent()) {
            throw new IllegalStateException("This book is already added to your BookList");
        }
        repository.save(book);
    }

    public static void deleteBookByIndex(int index) {
        int id = 0;
        List<Book> books = repository.findAll();
        int count = 1;
        for (Book book : books) {
            if (index == count) {
                id = book.getId();
            }
            count++;
        }

        boolean isExist = repository.existsById(id);

        if (!isExist) {
            throw new IllegalStateException("Invalid index");
        }

        repository.deleteById(id);
    }

    public static BooksRepository getRepository() {
        return repository;
    }
}
