package com.digital_libary.Digital_Library.rent.exception.subexception;

import com.digital_libary.Digital_Library.rent.exception.superexception.MainNotFoundException;

public class RentNotFoundException extends MainNotFoundException {
    public RentNotFoundException(String message) {
        super(message);
    }
}
