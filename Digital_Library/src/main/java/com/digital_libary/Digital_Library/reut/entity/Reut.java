package com.digital_libary.Digital_Library.reut.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reut")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Reut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "book_id", nullable = false)
    Long bookId;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(name = "date", nullable = false)
    LocalDate date;

    @Column(name = "default_date", nullable = false)
    LocalDate defaultDate;


}
