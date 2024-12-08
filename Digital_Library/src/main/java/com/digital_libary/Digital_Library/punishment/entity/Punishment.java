package com.digital_libary.Digital_Library.punishment.entity;

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
@Table(name = "punishment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Punishment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "user_id", nullable = false)
    String userId;

    @Column(name = "book_id", nullable = false)
    String bookId;

    @Column(name = "price", nullable = false)
    Double price;

    @Column(name = "start_date", nullable = false)
    LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    LocalDate endDate;


    @Column(name = "fine_amount", nullable = false)
    Double fineAmount;

    @Column(name = "reason", nullable = false)
    String reason;

    @Column(name = "status", nullable = false)
    String status;
}
