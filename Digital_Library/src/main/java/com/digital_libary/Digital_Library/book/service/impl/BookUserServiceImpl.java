package com.digital_libary.Digital_Library.book.service.impl;

import com.digital_libary.Digital_Library.book.dto.BookResponse;
import com.digital_libary.Digital_Library.book.entity.Book;
import com.digital_libary.Digital_Library.book.mapper.BookMapper;
import com.digital_libary.Digital_Library.book.repository.BookRepository;
import com.digital_libary.Digital_Library.book.service.BookUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookUserServiceImpl implements BookUserService {

    private final BookRepository repository;
    private final BookMapper mapper;

    @Override
    public List<BookResponse> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public List<BookResponse> getByCategory(String category) {
        List<Book> bookList=repository.findByCategoryContainingIgnoreCase(category);
        return bookList.stream().map(mapper::toDto).toList();
    }

    @Override
    public List<BookResponse> getByLanguage(String language) {
        List<Book> bookList=repository.findByLanguageContainingIgnoreCase(language);
        return  bookList.stream().map(mapper::toDto).toList();
    }

    @Override
    public List<BookResponse> getByAuthor(String author) {
        List<Book> bookList=repository.findByAuthorContainingIgnoreCase(author);
        return bookList.stream().map(mapper::toDto).toList();
    }

    @Override
    public List<BookResponse> getByName(String name) {
        List<Book> bookList=repository.findByNameContainingIgnoreCase(name);
        return bookList.stream().map(mapper::toDto).toList();
    }

    @Override
    public List<BookResponse> getByPriceBound(Double minPrice, Double maxPrice) {
        List<Book> bookList=repository.findByPriceBetween(minPrice, maxPrice);
        return bookList.stream().map(mapper::toDto).toList();
    }
}
