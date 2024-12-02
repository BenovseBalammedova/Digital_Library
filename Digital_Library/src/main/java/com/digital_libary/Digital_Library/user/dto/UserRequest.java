package com.digital_libary.Digital_Library.user.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    String username;

    Integer age;

    String email;

    String password;

    String phoneNumber;

    String address;

    String role;
}
