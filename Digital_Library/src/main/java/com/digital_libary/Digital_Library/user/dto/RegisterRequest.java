package com.digital_libary.Digital_Library.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RegisterRequest (
        @Email
        String email,
        String password){

}
