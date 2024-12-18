package com.digital_libary.Digital_Library.book.controller;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.dto.BookResponse;
import com.digital_libary.Digital_Library.book.entity.Book;
import com.digital_libary.Digital_Library.book.service.BookAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class BookAdminController {

    private final BookAdminService bookAdminService;


    @GetMapping()
    public List<Book> getAll() {
        return bookAdminService.getAll();
    }

    @GetMapping("{category}")
    public List<BookResponse> getByCategory(@PathVariable String category) {
        return bookAdminService.getByCategory(category);

    }

    @GetMapping("{language}")
    public List<BookResponse> getByLanguage(@PathVariable String language) {
        return bookAdminService.getByLanguage(language);
    }

    @GetMapping("{author}")
    public List<BookResponse> getByAuthor(@PathVariable String author) {
        return bookAdminService.getByAuthor(author);
    }

    @GetMapping("{name}")
    public List<BookResponse> getByName(@PathVariable String name) {
        return bookAdminService.getByName(name);

    }

    @GetMapping("price-between/{min-price}/{max-price}")
    public List<BookResponse> getByPriceBound(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        return bookAdminService.getByPriceBound(minPrice, maxPrice);
    }

    @GetMapping("{id}")
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
