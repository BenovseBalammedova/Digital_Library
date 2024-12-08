package com.digital_libary.Digital_Library.book.service;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.entity.Book;

import java.util.List;

public interface BookAdminService {

    List<Book> getAll();

    List<Book> getByCategory(String category);

    List<Book> getByLanguage(String language);

    List<Book> getByAuthor(String author);

    List<Book> getByName(String name);

    List<Book> getByPriceBound(Double minPrice, Double maxPrice);

    Book getById(Long id);

    void create(BookRequest book);

    void update(Long id, BookRequest book);

    void delete(Long id);
}
