package com.digital_libary.Digital_Library.book.service.impl;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.dto.BookResponse;
import com.digital_libary.Digital_Library.book.entity.Book;
import com.digital_libary.Digital_Library.book.exception.subeexception.BookInvalidException;
import com.digital_libary.Digital_Library.book.exception.subeexception.BookNotFountException;
import com.digital_libary.Digital_Library.book.mapper.BookMapper;
import com.digital_libary.Digital_Library.book.repository.BookRepository;
import com.digital_libary.Digital_Library.book.service.BookAdminService;
import com.digital_libary.Digital_Library.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BookAdminServiceImpl implements BookAdminService {

    private final BookRepository repository;

    private final BookMapper mapper;

    private final ReportService reportService;

    @Override
    public List<Book> getAll() {

        return repository.findAll();
    }

    @Override
    public List<BookResponse> getByCategory(String category) {
        List<Book> bookList=repository.findByCategoryContainingIgnoreCase(category);
        return bookList.stream().map(mapper::toDto).toList();
    }

    @Override
    public List<BookResponse> getByLanguage(String language) {
        List<Book> bookList=repository.findByLanguageContainingIgnoreCase(language);
        return bookList.stream().map(mapper::toDto).toList();
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

    @Override
    public Book getById(Long id) {
        if (id <= 0) {
            throw new BookInvalidException("Id is not correct");
        }
        return repository.findById(id).orElseThrow(() -> new BookNotFountException("Book is not found"));
    }

    @Override
    public void create(BookRequest book) {
        Book books = mapper.toEntity(book);
        repository.save(books);
        reportService.incrementBookCount();
    }

    @Override
    public void update(Long id, BookRequest book) {
        if (id <= 0) {
            throw new BookInvalidException("Id is not correct");
        }
        Book books = repository.findById(id).orElseThrow(() -> new BookNotFountException("Book is not found"));
        mapper.updateBookFromDto(book, books);
        repository.save(books);
    }

    @Override
    public void delete(Long id) {
        if (id <= 0) {
            throw new BookInvalidException("Id is not correct");

        }
        repository.deleteById(id);

    }
}
