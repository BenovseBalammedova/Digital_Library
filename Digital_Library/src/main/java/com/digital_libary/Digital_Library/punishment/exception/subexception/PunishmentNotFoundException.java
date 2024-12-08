package com.digital_libary.Digital_Library.punishment.exception.subexception;

import com.digital_libary.Digital_Library.punishment.exception.superexception.MainNotFoundException;

public class PunishmentNotFoundException extends MainNotFoundException {
    public PunishmentNotFoundException(String message) {
        super(message);
    }
}
