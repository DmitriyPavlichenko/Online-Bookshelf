package com.bookshelf;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookshelf")
public class Book {
    // Primary key
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Books information
    @NonNull
    @Max(value = 50, message = "Book name cannot be bigger than 50 characters")
    @NotNull(message = "Book name cannot be null")
    private String name;
    @NonNull
    @Max(value = 50, message = "Author name cannot be bigger than 50 characters")
    @NotNull(message = "Author name cannot be null")
    private String author;
}
