package com.digital_libary.Digital_Library.punishment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Punishment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Punishment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(name = "book_id", nullable = false)
    Long bookId;

    @Column(name = "price", nullable = false)
    Double price;
}
