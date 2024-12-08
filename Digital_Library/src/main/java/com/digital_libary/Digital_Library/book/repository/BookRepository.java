package com.digital_libary.Digital_Library.book.repository;

import com.digital_libary.Digital_Library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByCategoryContainingIgnoreCase(String category);

    List<Book> findByLanguageContainingIgnoreCase(String language);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByNameContainingIgnoreCase(String name);

    List<Book> findByPriceBetween(Double minPrice,Double maxPrice);

}