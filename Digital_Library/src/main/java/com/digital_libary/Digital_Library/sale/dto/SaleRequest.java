package com.digital_libary.Digital_Library.sale.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SaleRequest {

    String fkBookId;

    String fkUserId;

    String fkSalesmanId;

    String fkPaymentId;

    Double totalAmount;

    LocalDate saleDate;

    Long count;

    Double price;

    Double discount;

    String type;
}