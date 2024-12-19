package com.digital_libary.Digital_Library.user.dto;

import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {
        @Email
        String email;

        String password;

        String username;

        Boolean isActive;

        Integer age;

        String phoneNumber;

        String address;

        String role;

}
