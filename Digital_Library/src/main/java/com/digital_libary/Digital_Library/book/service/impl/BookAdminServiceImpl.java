package com.digital_libary.Digital_Library.book.service.impl;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.entity.Book;
import com.digital_libary.Digital_Library.book.exception.subeexception.BookInvalidException;
import com.digital_libary.Digital_Library.book.exception.subeexception.BookNotFountException;
import com.digital_libary.Digital_Library.book.mapper.BookMapper;
import com.digital_libary.Digital_Library.book.repository.BookRepository;
import com.digital_libary.Digital_Library.book.service.BookAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BookAdminServiceImpl implements BookAdminService {

    private final BookRepository repository;

    private final BookMapper bookMapper;

    @Override
    public List<Book> getAll() {

        return repository.findAll();
    }

    @Override
    public List<Book> getByCategory(String category) {
        return repository.findByCategoryContainingIgnoreCase(category);
    }

    @Override
    public List<Book> getByLanguage(String language) {
        return repository.findByLanguageContainingIgnoreCase(language);
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return repository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> getByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Book> getByPriceBound(Double price1, Double price2) {
        return repository.findByPriceBetween(price1, price2);

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
        Book books = bookMapper.toEntity(book);
        repository.save(books);

    }

    @Override
    public void update(Long id, BookRequest book) {
        if (id <= 0) {
            throw new BookInvalidException("Id is not correct");
        }
        Book books = repository.findById(id).orElseThrow(() -> new BookNotFountException("Book is not found"));
        bookMapper.updateBookFromDto(book, books);
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
