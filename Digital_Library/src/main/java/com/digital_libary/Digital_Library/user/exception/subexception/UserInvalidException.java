package com.digital_libary.Digital_Library.user.exception.subexception;

import com.digital_libary.Digital_Library.user.exception.superexception.MainInvalidException;

public class UserInvalidException extends MainInvalidException {
    public UserInvalidException(String message) {
        super(message);
    }
}
