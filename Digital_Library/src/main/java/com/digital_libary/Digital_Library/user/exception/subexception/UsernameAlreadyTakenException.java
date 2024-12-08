package com.digital_libary.Digital_Library.user.exception.subexception;

import com.digital_libary.Digital_Library.user.exception.superexception.MainBadRequestException;

public class UsernameAlreadyTakenException extends MainBadRequestException {

    public UsernameAlreadyTakenException(String message) {
        super(message);
    }
}
