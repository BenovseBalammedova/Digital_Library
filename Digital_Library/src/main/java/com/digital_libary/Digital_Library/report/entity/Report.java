package com.digital_libary.Digital_Library.report.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "total_discount")
    private Double totalDiscount;

    @Column(name = "book_count")
    Long bookCount;

    @Column(name = "user_count")
    Long userCount;

    @Column(name = "total_sales_book")
    Long totalSalesBook;

    @Column(name = "sale_count")
    Long saleCount;

    @Column(name = "total_fine_amount")
    Double totalFineAmount;

}
