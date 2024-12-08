package com.digital_libary.Digital_Library.report.dto;


import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReportRequest {

    Long bookCount;

    Long userCount;

    Long saleCount;

    Double totalDiscount;

    Double totalSalesBook;

    Double totalFineAmount;
}
