package com.digital_libary.Digital_Library.punishment.exception;

import com.digital_libary.Digital_Library.sale.exception.ErrorDetails;
import com.digital_libary.Digital_Library.sale.exception.superexception.MainInvalidException;
import com.digital_libary.Digital_Library.sale.exception.superexception.MainNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class PunishmentExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MainNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public final ResponseEntity<Object> handlePunishmentException(Exception ex, WebRequest webRequest) {
        com.digital_libary.Digital_Library.sale.exception.ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MainInvalidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Object> handlePunishmentInvalidException(Exception ex, WebRequest webRequest) {
        com.digital_libary.Digital_Library.sale.exception.ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
