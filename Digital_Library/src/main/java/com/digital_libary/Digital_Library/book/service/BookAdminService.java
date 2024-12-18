package com.digital_libary.Digital_Library.book.service;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.dto.BookResponse;
import com.digital_libary.Digital_Library.book.entity.Book;

import java.util.List;

public interface BookAdminService {

    List<Book> getAll();

    List<BookResponse> getByCategory(String category);

    List<BookResponse> getByLanguage(String language);

    List<BookResponse> getByAuthor(String author);

    List<BookResponse> getByName(String name);

    List<BookResponse> getByPriceBound(Double minPrice, Double maxPrice);

    Book getById(Long id);

    void create(BookRequest book);

    void update(Long id, BookRequest book);

    void delete(Long id);
}
