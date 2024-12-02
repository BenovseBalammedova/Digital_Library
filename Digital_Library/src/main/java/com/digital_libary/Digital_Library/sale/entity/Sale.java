package com.digital_libary.Digital_Library.sale.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sale")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "book_id", nullable = false)
    String fkBookId;

    @Column(name = "user_id", nullable = false)
    String fkUserId;

    @Column(name = "salesman_id", nullable = false)
    String fkSalesmanId;

    @Column(name = "payment_id", nullable = false)
    String fkPaymentId;

    @Column(name = "sale_date", nullable = false)
    LocalDate saleDate;

    @Column(name = "count", nullable = false)
    Long count;

    @Column(name = "price", nullable = false)
    Double price;

    @Column(name = "total_amount", nullable = false)
    Double totalAmount;

    @Column(name = "discount", nullable = false)
    Double discount;

    @Column(name = "type", nullable = false)
    String type;

}
