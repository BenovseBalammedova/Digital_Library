package com.digital_libary.Digital_Library.book.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

    String name;

    String category;

    String author;

    LocalDate publishedYear;

    Long count;

    Double price;

    String language;

}
