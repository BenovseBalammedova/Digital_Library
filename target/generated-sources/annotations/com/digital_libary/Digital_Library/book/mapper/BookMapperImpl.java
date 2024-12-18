package com.digital_libary.Digital_Library.book.mapper;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.dto.BookResponse;
import com.digital_libary.Digital_Library.book.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-18T04:16:56-0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookResponse toDto(Book bookResponse) {
        if ( bookResponse == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse1 = BookResponse.builder();

        bookResponse1.name( bookResponse.getName() );
        bookResponse1.category( bookResponse.getCategory() );
        bookResponse1.author( bookResponse.getAuthor() );
        bookResponse1.publishedYear( bookResponse.getPublishedYear() );
        bookResponse1.count( bookResponse.getCount() );
        bookResponse1.price( bookResponse.getPrice() );
        bookResponse1.language( bookResponse.getLanguage() );

        return bookResponse1.build();
    }

    @Override
    public Book toEntity(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.name( bookRequest.getName() );
        book.category( bookRequest.getCategory() );
        book.author( bookRequest.getAuthor() );
        book.publishedYear( bookRequest.getPublishedYear() );
        book.count( bookRequest.getCount() );
        book.price( bookRequest.getPrice() );
        book.language( bookRequest.getLanguage() );

        return book.build();
    }

    @Override
    public void updateBookFromDto(BookRequest updatedBook, Book existingBook) {
        if ( updatedBook == null ) {
            return;
        }

        existingBook.setName( updatedBook.getName() );
        existingBook.setCategory( updatedBook.getCategory() );
        existingBook.setAuthor( updatedBook.getAuthor() );
        existingBook.setPublishedYear( updatedBook.getPublishedYear() );
        existingBook.setCount( updatedBook.getCount() );
        existingBook.setPrice( updatedBook.getPrice() );
        existingBook.setLanguage( updatedBook.getLanguage() );
    }
}
