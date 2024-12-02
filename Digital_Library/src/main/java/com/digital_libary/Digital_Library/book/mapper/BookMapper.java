package com.digital_libary.Digital_Library.book.mapper;

import com.digital_libary.Digital_Library.book.dto.BookRequest;
import com.digital_libary.Digital_Library.book.dto.BookResponse;
import com.digital_libary.Digital_Library.book.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface BookMapper {

    BookResponse toDto(Book bookResponse);

    Book toEntity(BookRequest bookRequest);

    void updateBookFromDto(BookRequest updatedBook, @MappingTarget Book existingBook);
}
