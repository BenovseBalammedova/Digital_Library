package com.digital_libary.Digital_Library.book.service;

import com.digital_libary.Digital_Library.book.dto.BookResponse;

import java.util.List;

public interface BookUserService {

    List<BookResponse> getAll();

    List<BookResponse> getByCategory(String category);

    List<BookResponse> getByLanguage(String language);

    List<BookResponse> getByAuthor(String author);

    List<BookResponse> getByName(String name);

    List<BookResponse> getByPriceBound(Double minPrice,Double maxPrice);




}
