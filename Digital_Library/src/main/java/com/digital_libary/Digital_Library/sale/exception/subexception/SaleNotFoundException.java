package com.digital_libary.Digital_Library.sale.exception.subexception;

import com.digital_libary.Digital_Library.sale.exception.superexception.MainNotFoundException;

public class SaleNotFoundException extends MainNotFoundException {
    public SaleNotFoundException(String message) {
        super(message);
    }
}
