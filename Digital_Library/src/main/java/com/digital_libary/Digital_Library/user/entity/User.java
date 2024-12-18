package com.digital_libary.Digital_Library.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "username", nullable = false, unique = true)
    String username;

    @Column(name = "age", nullable = false)
    Integer age;

    @Column(name = "email", nullable = false,unique = true)
    String email;

    @Column(name = "password", nullable = false)
    String password;

//    @Column(name = "is_active")
//    private Boolean isActive;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "role", nullable = false)
    String role;

}
