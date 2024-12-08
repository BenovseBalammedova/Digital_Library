package com.digital_libary.Digital_Library.rent.exception.subexception;

import com.digital_libary.Digital_Library.rent.exception.superexception.MainInvalidException;

public class RentInvalidException extends MainInvalidException {
    public RentInvalidException(String message) {
        super(message);
    }
}
