package com.digital_libary.Digital_Library.book.controller;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.entity.Book;
import com.digital_libary.Digital_Library.book.service.BookAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class BookAdminController {

    private final BookAdminService bookAdminService;


    @GetMapping("get-all")
    public List<Book> getAll() {
        return bookAdminService.getAll();
    }

    @GetMapping("/category/{category}")
    public List<Book> getByCategory(@PathVariable String category) {
        return bookAdminService.getByCategory(category);

    }

    @GetMapping("/language/{language}")
    public List<Book> getByLanguage(@PathVariable String language) {
        return bookAdminService.getByLanguage(language);
    }

    @GetMapping("/author/{author}")
    public List<Book> getByAuthor(@PathVariable String author) {
        return bookAdminService.getByAuthor(author);
    }

    @GetMapping("/name/{name}")
    public List<Book> getByName(String name) {
        return bookAdminService.getByName(name);

    }

    @GetMapping("/price/{price1}/{price2}")
    public List<Book> getByPriceBound(@PathVariable Double price1, @PathVariable Double price2) {
        return bookAdminService.getByPriceBound(price1, price2);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookAdminService.getById(id);
    }

    @PostMapping()
    public void create(@RequestBody BookRequest book) {
        bookAdminService.create(book);


    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody BookRequest book) {
        bookAdminService.update(id, book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookAdminService.delete(id);

    }


}
