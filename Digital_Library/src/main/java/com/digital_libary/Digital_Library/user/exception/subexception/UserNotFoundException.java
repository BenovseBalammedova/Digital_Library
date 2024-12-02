package com.digital_libary.Digital_Library.user.exception.subexception;


import com.digital_libary.Digital_Library.user.exception.superexception.MainNotFoundException;

public class UserNotFoundException extends MainNotFoundException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
