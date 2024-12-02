package com.digital_libary.Digital_Library.book.exception;


import java.time.LocalDateTime;

public record ErrorDetails(
        LocalDateTime timeStamp,
        String message,
        String details
) {

}
