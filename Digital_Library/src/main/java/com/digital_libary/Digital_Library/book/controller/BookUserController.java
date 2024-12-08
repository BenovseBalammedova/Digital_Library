package com.digital_libary.Digital_Library.book.controller;

import com.digital_libary.Digital_Library.book.dto.BookResponse;
import com.digital_libary.Digital_Library.book.service.BookUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class BookUserController {

    private final BookUserService bookUserService;

    @GetMapping("get-all")
    public List<BookResponse> getAll() {
        return bookUserService.getAll();
    }

    @GetMapping("/category/{category}")
    public List<BookResponse> getByCategory(@PathVariable String category) {
        return bookUserService.getByCategory(category);

    }

    @GetMapping("/language/{language}")
    public List<BookResponse> getByLanguage(@PathVariable String language) {
        return bookUserService.getByLanguage(language);


    }

    @GetMapping("/author/{author}")
    public List<BookResponse> getByAuthor(@PathVariable String author) {
        return bookUserService.getByAuthor(author);

    }

    @GetMapping("/name/{name}")
    public List<BookResponse> getByName(@PathVariable String name) {
        return bookUserService.getByName(name);
    }

    @GetMapping("/price/{price1}/{price2}")
    public List<BookResponse> getByPriceBound(@PathVariable Double price1, @PathVariable Double price2) {
        return bookUserService.getByPriceBound(price1, price2);
    }


}
