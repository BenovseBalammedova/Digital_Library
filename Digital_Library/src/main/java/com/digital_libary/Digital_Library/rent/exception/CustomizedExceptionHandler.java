package com.digital_libary.Digital_Library.rent.exception;

import com.digital_libary.Digital_Library.book.exception.ErrorDetails;

import com.digital_libary.Digital_Library.rent.exception.superexception.MainInvalidException;
import com.digital_libary.Digital_Library.rent.exception.superexception.MainNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class CustomizedExceptionHandler {

    @ExceptionHandler(MainNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public final ResponseEntity<Object> handleNotFoundRentException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MainInvalidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handleInvalidRentException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
