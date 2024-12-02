package com.digital_libary.Digital_Library.book.exception.subeexception;

import com.digital_libary.Digital_Library.book.exception.superexception.MainInvalidException;

public class BookInvalidException extends MainInvalidException {
    public BookInvalidException(String message) {
        super(message);
    }
}
