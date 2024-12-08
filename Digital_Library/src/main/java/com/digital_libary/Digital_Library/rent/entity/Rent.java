package com.digital_libary.Digital_Library.rent.entity;

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
@Table(name = "rent")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "book_id", nullable = false)
    String bookId;

    @Column(name = "user_id", nullable = false)
    String userId;

    @Column(name = "start_date", nullable = false)
    LocalDate startDate;

    @Column(name = "return_date", nullable = false)
    LocalDate returnDate;

}
