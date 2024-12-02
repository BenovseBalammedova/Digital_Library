package com.digital_libary.Digital_Library.book.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Book")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "category", nullable = false)
    String category;

    @Column(name = "author", nullable = false)
    String author;

    @Column(name = "published_year", nullable = false)
    LocalDate publishedYear;

    @Column(name = "count", nullable = false)
    Long count;

    @Column(name = "price", nullable = false)
    Double price;

    @Column(name = "language", nullable = false)
    String language;

}
