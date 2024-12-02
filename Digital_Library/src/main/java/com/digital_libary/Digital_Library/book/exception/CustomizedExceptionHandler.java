package com.digital_libary.Digital_Library.book.exception;

import com.digital_libary.Digital_Library.book.exception.superexception.MainInvalidException;
import com.digital_libary.Digital_Library.book.exception.superexception.MainNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice

public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MainNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MainInvalidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handleInvalidBookException(Exception ex,WebRequest request){
        ErrorDetails errorDetails =new ErrorDetails(
                LocalDateTime.now(), ex.getMessage(), request.getDescription(false)
        );
                return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
}
