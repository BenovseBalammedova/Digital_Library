package com.digital_libary.Digital_Library.payment.entity;

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
@Table(name = "Payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "currency", nullable = false)
    String currency;

    @Column(name = "quantity", nullable = false)
    Long quantity;

    @Column(name = "card_number", nullable = false)
    String cardNumber;

}
