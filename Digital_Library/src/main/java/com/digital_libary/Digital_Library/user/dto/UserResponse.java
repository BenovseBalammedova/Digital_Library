package com.digital_libary.Digital_Library.user.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;

    String username;

    Integer age;

    String email;

    String phoneNumber;

    String address;

    String role;

}
