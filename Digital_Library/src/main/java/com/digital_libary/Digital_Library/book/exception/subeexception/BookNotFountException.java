package com.digital_libary.Digital_Library.book.exception.subeexception;

import com.digital_libary.Digital_Library.book.exception.superexception.MainNotFoundException;

public class BookNotFountException extends MainNotFoundException {
    public BookNotFountException(String message) {
        super(message);
    }
}
